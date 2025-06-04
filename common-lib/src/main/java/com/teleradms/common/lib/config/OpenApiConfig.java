package com.teleradms.common.lib.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public OpenAPI  openAPI() {
        return new OpenAPI()
                .info(buildInfo())
                .externalDocs(buildExternalDocs());
    }

    private Info  buildInfo() {
        return new Info()
                .title("TeleRadiologyMS - Member Service API")
                .description("This service manages member-related operations within the TeleRadiology Management System.")
                .version("1.0.0")
                .contact(buildContact())
                .license(buildLicense());
    }

    private Contact buildContact() {
        return new Contact()
                .name("TeleRadiologyMS Dev Team")
                .email("devteam@teleradiologyms.com")
                .url("https://teleradiologyms.com");
    }

    private License buildLicense() {
        return new License()
                .name("Apache 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0");
    }

    private ExternalDocumentation buildExternalDocs() {
        return new ExternalDocumentation()
                .description("TeleRadiologyMS Project Wiki")
                .url("https://github.com/orhanturkmenoglu/TeleradiologyMS");
    }

    @Bean
    public GroupedOpenApi groupedOpenApi(){
        return GroupedOpenApi.builder()
                .group(applicationName+" API")
                .pathsToMatch("/api/v1/**")
                .build();
    }

}
