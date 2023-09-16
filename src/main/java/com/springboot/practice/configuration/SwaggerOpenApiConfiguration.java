package com.springboot.practice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Component
public class SwaggerOpenApiConfiguration {


	@Bean
	public OpenAPI PatientOpenApi() {
		return new OpenAPI()
				.info(new Info().title("Patient API")
					.description("REST API for Patient Controller")	
					.version("1.0"));
	
	}
}
