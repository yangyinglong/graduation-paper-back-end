package cn.hdu.fragmentTax.controller.config;

import cn.hdu.fragmentTax.controller.endpoint.AuthorizeController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * 配置Jersey
 *
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(AuthorizeController.class);
	}
//
//	@Bean
//	public ServletRegistrationBean jerseyServlet() {
//		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/api/*");
//		// our rest resources will be available in the path /rest/*
//		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyResourceConfig.class.getName());
//		return registration;
//	}
}
