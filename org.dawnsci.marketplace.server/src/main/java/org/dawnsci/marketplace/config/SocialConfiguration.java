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

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

/**
 * Configures the Twitter and Google integrations to use a database to store
 * connection information. Also sets up the Google connection factory.
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@Configuration
@EnableSocial
public class SocialConfiguration implements SocialConfigurer {
	
	@Inject
	private DataSource dataSource;
	
	@Inject
	private TextEncryptor textEncryptor;
	
	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer,
			Environment environment) {
		// a TwitterConnectionFactory has already been configured elsewhere
        connectionFactoryConfigurer.addConnectionFactory(new GoogleConnectionFactory(
            environment.getProperty("spring.social.google.app-id"),
            environment.getProperty("spring.social.google.app-secret")));
	}

	@Override
	public UserIdSource getUserIdSource() {
		return new AuthenticationNameUserIdSource();
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		return new JdbcUsersConnectionRepository(dataSource,connectionFactoryLocator,textEncryptor);
	}
}
