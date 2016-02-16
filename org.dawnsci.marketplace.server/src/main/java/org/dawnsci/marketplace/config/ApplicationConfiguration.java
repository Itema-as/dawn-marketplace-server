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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ApplicationConfiguration {

	@Inject
	Environment env;

	/**
	 * Whether or not to populate the server with some initial data.
	 */
	@Bean
	public Boolean initializeData() {
		if (env.getProperty("init") == null) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}

	}

}
