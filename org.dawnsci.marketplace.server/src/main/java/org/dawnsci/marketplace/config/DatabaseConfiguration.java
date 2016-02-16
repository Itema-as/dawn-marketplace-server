/*****************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Torkild U. Resheim - initial API and implementation
 ****************************************************************************/
package org.dawnsci.marketplace.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * Configures the database to use for system information such as user accounts.
 *  
 * @author Torkild U. Resheim, Itema AS
 */
@Configuration
public class DatabaseConfiguration {
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DataSource dataSource = createDataSource();
		DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
		return dataSource;
	}

	private DatabasePopulator createDatabasePopulator() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		// populate the database with required tables
		databasePopulator.addScript(new ClassPathResource("schema.sql"));
		return databasePopulator;
	}

	private SimpleDriverDataSource createDataSource() {
		SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
		simpleDriverDataSource.setDriverClass(org.hsqldb.jdbcDriver.class);
		simpleDriverDataSource.setUrl("jdbc:hsqldb:file:database/system;shutdown=true;hsqldb.default_table_type=cached");
		simpleDriverDataSource.setUsername("");
		simpleDriverDataSource.setPassword("");
		return simpleDriverDataSource;
	}
}
