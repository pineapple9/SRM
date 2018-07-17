package com.srm.accounting.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import javax.sql.DataSource;
import org.springframework.jdbc.datasource.*;

import javax.sql.DataSource;

@Controller
@EnableAutoConfiguration
public class AccountingIndexController {

	/*@Primary
	@Bean(name ="prodDataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}*/

	@Autowired
	DataSource dataSource;

	// inject via application.properties
	@Value("Hello World2")
	private String message;

	@RequestMapping("/Accounting")
	public String index(Map<String, Object> model) {
//		model.put("message", this.message);
		model.put("message", "Accounting");

		System.out.println("Our DataSource is = " + dataSource);

		return "accounting/indexAccounting";
	}

//    @Override
            //   public void run(String... strings) throws Exception {
    //      System.out.println("DATASOURCE = " + dataSource);
    //  }
}