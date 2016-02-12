package org.dawnsci.marketplace.config;

import javax.sql.DataSource;

import org.dawnsci.marketplace.social.account.JdbcAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;

@Configuration
public class DatabaseConfiguration {
	
	@Bean(destroyMethod = "shutdown")
	public DataSource dataSource() {
		EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
		factory.setDatabaseName("marketplace-users");
		factory.setDatabaseType(EmbeddedDatabaseType.HSQL);
		factory.setDatabasePopulator(databasePopulator());
		return factory.getDatabase();
	}

	/**
	 * Create tables and inserts some initial data.
	 * @return
	 */
	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("JdbcUsersConnectionRepository.sql", JdbcUsersConnectionRepository.class));
		populator.addScript(new ClassPathResource("/Account.sql", JdbcAccountRepository.class));
		populator.addScript(new ClassPathResource("/data.sql", JdbcAccountRepository.class));
		return populator;
	}
}
