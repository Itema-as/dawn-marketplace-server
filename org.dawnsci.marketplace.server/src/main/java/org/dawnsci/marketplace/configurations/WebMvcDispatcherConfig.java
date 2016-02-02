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
package org.dawnsci.marketplace.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Torkild U. Resheim, Itema AS
 */
@Configuration
public class WebMvcDispatcherConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("static/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("static/css/");
		registry.addResourceHandler("/html/**").addResourceLocations("static/html/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("static/fonts/");
		registry.addResourceHandler("/images/**").addResourceLocations("static/images/");
	}
}