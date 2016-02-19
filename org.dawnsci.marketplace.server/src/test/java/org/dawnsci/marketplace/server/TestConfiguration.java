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

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Special configuration that keeps the marketplace data in XML files so
 * that tests can be executed without access to a persistence layer. The data
 * files are created using output from the official marketplace server at
 * http://marketplace.eclipse.org
 * 
 * @author Torkild U. Resheim
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.dawnsci.marketplace" })
@Profile("test")
public class TestConfiguration {
	
	@Bean
	@Primary
	public Boolean initinitializeData(){
		return Boolean.TRUE; 
	}
	
}