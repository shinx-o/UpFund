package com.upfunds.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackages = { "com.*" })
@EnableJpaRepositories(basePackages = { "com.repository" })
@ComponentScan(basePackages = { "com.*" })
@EnableSwagger2
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
		System.out.println("Hello world spring boot app started...");
	}
	
	@Bean
	public Docket swaggerConfiguration()
	{
		ParameterBuilder aParameterBuilder=new ParameterBuilder();
		
		aParameterBuilder.name("Authorization")
		.modelRef(new ModelRef("string"))
		.parameterType("header")
		.defaultValue("Basic i38kdks8x")
		.required(false)
		.build();
		
		java.util.List<Parameter> allParameters=new ArrayList<>();
		
		allParameters.add(aParameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**")) // this is for all URIs & sub-URIs // this is only for all URIs
//				.paths(PathSelectors.ant("/api/*"))  //this is for all URIs starting with api
				.apis(RequestHandlerSelectors.basePackage("com."))
				.build()
				.globalOperationParameters(allParameters)
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
	    return new ApiInfo(
	        "Upfunds REST API",
	        "Mutual Fund Investment",
	        "Version 1.0, APIs for ₹1000,000,000",
	        "APIs for ₹1000,000,000",
	        null, // Remove the Contact parameter
	        null,
	        "", // Set the empty string for the URL
	        Collections.emptyList()
	    );
	}	
	
	

}
