package com.estock.users.util;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(generateAPIInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.estock.users.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo generateAPIInfo() {
        return new ApiInfo("Users Management Api", "", "1.0.0",
            "", getContacts(), "", "", new ArrayList<>());
    }

    private Contact getContacts() {
        return new Contact("Sivasuriyan Baskaran", "", "");
    }

}