package org.dawnsci.marketplace.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Torkild U. Resheim, Itema AS
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/signin").setViewName("signin");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }	

	@Bean
	public CommonsMultipartResolver multipartResolver(){
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setDefaultEncoding("UTF-8");
	    multipartResolver.setMaxUploadSize(1_073_741_824); // 1GB
	    return multipartResolver;
	}	
	@Override
	  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer.favorPathExtension(false).
	            favorParameter(true).
	            parameterName("mediaType").
	            ignoreAcceptHeader(true).
	            useJaf(false).
	            defaultContentType(MediaType.TEXT_HTML).
	            mediaType("xml", MediaType.APPLICATION_XML).
	            mediaType("json", MediaType.APPLICATION_JSON);
	  }}

