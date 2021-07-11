package com.estock.zuulapigatewayserver.security;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
public class SwaggerDocConfig implements SwaggerResourcesProvider {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List get() {
		List resources = new ArrayList();
		resources.add(swaggerResource("estock-users", "/estock-users/v2/api-docs", "1.0.0"));
		resources.add(swaggerResource("stock-management", "/estock-management/v2/api-docs", "1.0.0"));
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}