package com.srm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        /*System.out.println("SpringApplicationBuilder");
        System.out.println(application.sources(SpringBootWebApplication.class).toString());*/
	    return application.sources(SpringBootWebApplication.class);
	}


//	public static void main(String[] args) {
//	    System.out.println("main");
//		SpringApplication.run(SpringBootWebApplication.class, args);
//	}

}