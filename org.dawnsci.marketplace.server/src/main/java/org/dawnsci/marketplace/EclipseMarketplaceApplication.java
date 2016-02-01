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

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main entry point.
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@EnableWebMvc
@ComponentScan(basePackages = "org.dawnsci.marketplace")
@Import(WebMvcInitializer.class)
@SpringBootApplication
public class EclipseMarketplaceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EclipseMarketplaceApplication.class);
	}

	public static void main(String[] args) {
		new EclipseMarketplaceApplication().configure(new SpringApplicationBuilder(EclipseMarketplaceApplication.class))
				.run(args);
	}

}
