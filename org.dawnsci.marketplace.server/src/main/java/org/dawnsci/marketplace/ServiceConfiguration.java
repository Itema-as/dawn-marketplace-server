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

import javax.inject.Inject;

import org.dawnsci.marketplace.services.MarketplaceDAO;
import org.dawnsci.marketplace.services.FileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Torkild U. Resheim, Itema AS
 */
@Configuration
public class ServiceConfiguration {
		
	@Inject
	private Environment environment;

	@Bean
	public MarketplaceDAO catalogService() {
		return new MarketplaceDAO();
	}
	
	@Bean
	public FileService fileService() {
		return new FileService(environment);
	}

}
