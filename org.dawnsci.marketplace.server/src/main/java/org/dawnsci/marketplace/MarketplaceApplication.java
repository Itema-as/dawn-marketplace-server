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
package org.dawnsci.marketplace;

import org.dawnsci.marketplace.config.ApplicationConfiguration;
import org.dawnsci.marketplace.social.signin.SimpleSignInAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.social.connect.web.SignInAdapter;

@ComponentScan(basePackages = "org.dawnsci.marketplace")
@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
public class MarketplaceApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// convert the command line argument to properties
		CommandLinePropertySource<?> ps = new SimpleCommandLinePropertySource(args);
		ctx.getEnvironment().getPropertySources().addFirst(ps);
		ctx.register(ApplicationConfiguration.class);
		ctx.refresh();
		try {
			SpringApplication.run(MarketplaceApplication.class, args);
		} finally {
			ctx.close();
		}
	}

	@Bean
	public SignInAdapter signInAdapter() {
		return new SimpleSignInAdapter(new HttpSessionRequestCache());
	}
}
