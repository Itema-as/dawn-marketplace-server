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
package org.dawnsci.marketplace.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Torkild U. Resheim, Itema AS
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	static Log log = LogFactory.getLog(SecurityConfiguration.class.getName());
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring().antMatchers("/**");
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {                
    	http
    		.authorizeRequests()	        
    			.anyRequest()
	            .authenticated();
//	            .and()
//	        .formLogin()
//	            .loginPage("/signin")
//	            .permitAll()
//	            .and()
//	        .logout()
//	        	.logoutSuccessUrl("/signin?logout")
//	        	.permitAll()
//	        .and()
//	        	.csrf().disable();
    }
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}    
    
//    @Autowired
//    private FilebasedAuthenticationProvider authenticationProvider;
//    
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider);
//	}
}
