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
