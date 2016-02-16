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

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;

/**
 * Configures the Twitter integration to use a database to store connection information
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@Configuration
@EnableSocial
public class SocialConfiguration {
	
	@Inject
	private DataSource dataSource;
	
	@Inject
	private TextEncryptor textEncryptor;
	
	@Bean	
	public UsersConnectionRepository usersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator){
		return new JdbcUsersConnectionRepository(dataSource,connectionFactoryLocator,textEncryptor);		
	}
}
