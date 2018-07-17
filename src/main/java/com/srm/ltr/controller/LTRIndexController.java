package com.srm.ltr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class LTRIndexController {

	/*@Primary
	@Bean(name ="prodDataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}*/

	@Autowired
	DataSource prodDataSource;

	// inject via application.properties
	@Value("Hello World2")
	private String message;

	@RequestMapping("/LTR")
	public String index(Map<String, Object> model) {
//		model.put("message", this.message);
		model.put("message", "LTR");

		System.out.println("Our prodDataSource is = " + prodDataSource);

		return "ltr/indexLTR";
	}

//    @Override
            //   public void run(String... strings) throws Exception {
    //      System.out.println("DATASOURCE = " + dataSource);
    //  }
}