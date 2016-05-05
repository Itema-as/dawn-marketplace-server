package org.dawnsci.marketplace.social.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.dawnsci.marketplace.config.SecurityConfiguration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcAccountRepository implements AccountRepository, PagingAndSortingRepository<Account, String> {

	private final JdbcTemplate jdbcTemplate;

	private final PasswordEncoder passwordEncoder;

	@Inject
	public JdbcAccountRepository(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
		this.jdbcTemplate = jdbcTemplate;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void createAccount(Account user) throws UsernameAlreadyInUseException {
		try {
			jdbcTemplate.update(
					"insert into Account (firstName, lastName, username, password) values (?, ?, ?, ?)",
					user.getFirstName(), user.getLastName(), user.getUsername(),
					passwordEncoder.encode(user.getPassword()));
			jdbcTemplate.update(
					"insert into Authorities (username, authority) values (?, ?)",
					user.getUsername(), "ROLE_USER");
		} catch (DuplicateKeyException e) {
			throw new UsernameAlreadyInUseException(user.getUsername());
		}
	}

	@Transactional
	public void createAccountSolutionMapping(Account user, Long solution){
		jdbcTemplate.update(
				"insert into SolutionConnection (username, solution) values (?, ?)",
				user.getUsername(), solution);
	}

	@Override
	@Transactional
	public Account findAccountBySolutionId(Long id) {
		List<String> query = jdbcTemplate.query("select username, solution from SolutionConnection where solution = ?",
				new RowMapper<String>() {
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						return  rs.getString("username");
					}
				}, id);
		// this solution does not have an specified owner so we're doing a fallback and assign it to the default
		// administrative user
		if (query.isEmpty()) {
			return findOne(SecurityConfiguration.ADMINISTRATOR_ID);
		}
		return findOne(query.get(0));
	}
	
	@Override
	@Transactional
	public List<Long> findSolutionIdsByUsername(String id) {
		return jdbcTemplate.query("select username, solution from SolutionConnection where username = ?",
				new RowMapper<Long>() {
					public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
						return  rs.getLong("solution");
					}
				}, id);
	}

	// TODO: Migrate to using PagingAndSortingRepository as needed

	/**
	 * Updates the account details. Note that this method will <b>not</b> update
	 * the user's password.
	 */
	@Override
	@Transactional
	public <S extends Account> S save(S entity) {
		jdbcTemplate.update("update Account set firstname = ?, lastname = ? where username = ?",
				entity.getFirstName(),
				entity.getLastName(),
				entity.getUsername());
		return entity;
	}

	@Override
	public <S extends Account> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Account findOne(String id) {
		if (id.equals(SecurityConfiguration.ADMINISTRATOR_ID)) {
			return new Account(SecurityConfiguration.ADMINISTRATOR_ID, null, "Administrator", "");
		}
		return jdbcTemplate.queryForObject("select username, firstName, lastName from Account where username = ?",
				new RowMapper<Account>() {
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Account(rs.getString("username"), null, rs.getString("firstName"), rs
								.getString("lastName"));
					}
				}, id);
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Account> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		jdbcTemplate.update(
				"delete from Account where username = ?", id);
		jdbcTemplate.update(
				"delete from Authorities where username = ?", id);
		jdbcTemplate.update(
				"delete from SolutionConnection where username = ?", id);
	}

	@Override
	public void delete(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Account> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Account> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Page<Account> findAll(Pageable pageable) {
		// find the total number of rows
		Integer total = jdbcTemplate.queryForObject("select count(*) from Account", new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}			
		});
		
		// calculate the offset
		int offset = pageable.getPageNumber() * pageable.getPageSize();
		
		// select the page
		List<Account> query = jdbcTemplate.query("select username, firstName, lastName from Account limit ? offset ?",
				new RowMapper<Account>() {
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Account(rs.getString("username"), null, rs.getString("firstName"), rs
								.getString("lastName"));
					}
				}, pageable.getPageSize(), offset);
		
		return new PageImpl<>(query, pageable, total);
	}

	@Override
	@Transactional
	public boolean isAdministrator(String id) {
		return jdbcTemplate.queryForObject("select count(*) from Authorities where username = ? and authority = 'ROLE_ADMIN'", new RowMapper<Boolean>() {
			@Override
			public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1) == 1;
			}			
		},id);
	}

	@Override
	@Transactional
	public boolean isUser(String id) {
		return jdbcTemplate.queryForObject("select count(*) from Authorities where username = ? and authority = 'ROLE_USER'", new RowMapper<Boolean>() {
			@Override
			public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1) == 1;
			}			
		},id);
	}

	@Override
	@Transactional
	public boolean isUpload(String id) {
		return jdbcTemplate.queryForObject("select count(*) from Authorities where username = ? and authority = 'ROLE_UPLOAD'", new RowMapper<Boolean>() {
			@Override
			public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1) == 1;
			}			
		},id);
	}

	@Override
	@Transactional
	public void setAdministrator(String username, boolean administrator) {
		if (administrator) {
			// only create the entry if it's not already in place
			if (!isAdministrator(username)) {
				jdbcTemplate.update(
						"insert into Authorities (username, authority) values (?, ?)",
						username, "ROLE_ADMIN");
			}
		} else {
			jdbcTemplate.update(
					"delete from Authorities where username = ? and authority = ?",
					username, "ROLE_ADMIN");
		}
		
	}

	@Override
	@Transactional
	public void setUser(String username, boolean user) {
		if (user) {
			// only create the entry if it's not already in place
			if (!isUser(username)){
				jdbcTemplate.update(
						"insert into Authorities (username, authority) values (?, ?)",
						username, "ROLE_USER");
			}
		} else {
			jdbcTemplate.update(
					"delete from Authorities where username = ? and authority = ?",
					username, "ROLE_USER");
		}
	}

	@Override
	@Transactional
	public void setUpload(String username, boolean upload) {
		if (upload) {
			// only create the entry if it's not already in place
			if (!isUpload(username)){
				jdbcTemplate.update(
						"insert into Authorities (username, authority) values (?, ?)",
						username, "ROLE_UPLOAD");
			}
		} else {
			jdbcTemplate.update(
					"delete from Authorities where username = ? and authority = ?",
					username, "ROLE_UPLOAD");
		}
	}
}
