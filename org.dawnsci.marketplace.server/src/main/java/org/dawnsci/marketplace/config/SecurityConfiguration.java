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

import java.util.UUID;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

	@Inject
	private Environment environment;

	@Inject
	private DataSource dataSource;
	
	public static final String ADMINISTRATOR_ID = "admin";
		
	@Autowired
	public void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		String password = UUID.randomUUID().toString();
		if (environment.containsProperty("marketplace.admin-password")) {
			password = environment.getProperty("marketplace.admin-password");
		} else {
			logger.info("Using generated administrator password: "+password);
		}
		auth	
			.inMemoryAuthentication()
				.withUser(ADMINISTRATOR_ID)
				.password(password)
				.roles("USER", "ADMIN")
			.and()
			.and()
			.jdbcAuthentication()
				.dataSource(dataSource)
					.usersByUsernameQuery("select username, password, true from Account where username = ?")
					.authoritiesByUsernameQuery("select username, authority from Authorities where username = ?")
					.passwordEncoder(passwordEncoder());
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder();
	}

	@Bean
	public TextEncryptor textEncryptor() {
		return Encryptors.noOpText();
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring().antMatchers("/css/**").and()
            .ignoring().antMatchers("/fonts/**").and()
            .ignoring().antMatchers("/images/**").and()
            .ignoring().antMatchers("/js/**").and()
            .ignoring().antMatchers("/pages/**").and()
        	.ignoring().antMatchers("/files/**");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin()
			.loginPage("/signin")
			.loginProcessingUrl("/signin/authenticate")
			.failureUrl("/signin?param.error=bad_credentials")
		.and()
			.logout()
				.logoutUrl("/signout")
				.deleteCookies("JSESSIONID")
		.and()
			.authorizeRequests()
	        	.antMatchers("/**").permitAll()
		     	.antMatchers(HttpMethod.POST, "/**").authenticated()
		        .antMatchers(HttpMethod.PUT, "/**").authenticated()
		        .antMatchers(HttpMethod.DELETE, "/**").authenticated()
		.and()
			.httpBasic()
		.and()
			.rememberMe();
	}

}