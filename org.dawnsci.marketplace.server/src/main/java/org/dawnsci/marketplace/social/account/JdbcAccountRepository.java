/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dawnsci.marketplace.social.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.dawnsci.marketplace.config.SecurityConfiguration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcAccountRepository implements AccountRepository {

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

	public Account findAccountByUsername(String username) {
		if (username.equals(SecurityConfiguration.ADMINISTRATOR_ID)) {
			return new Account(SecurityConfiguration.ADMINISTRATOR_ID, null, "Administrator", "");
		}
		return jdbcTemplate.queryForObject("select username, firstName, lastName from Account where username = ?",
				new RowMapper<Account>() {
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Account(rs.getString("username"), null, rs.getString("firstName"), rs
								.getString("lastName"));
					}
				}, username);
	}

	@Override
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
			return findAccountByUsername(SecurityConfiguration.ADMINISTRATOR_ID);
		}
		return findAccountByUsername(query.get(0));
	}

}
