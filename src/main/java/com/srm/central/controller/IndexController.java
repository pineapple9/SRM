package com.srm.central.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.Map;

@Controller
public class IndexController implements ErrorController {

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

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
//		model.put("message", this.message);
		model.put("message", "Central Index");

//		System.out.println("Our DataSource is = " + dataSource);

		return "central/index";
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {

				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error404.html");
				container.addErrorPages(error404Page);

			}
		};
	}
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error(Map<String, Object> model) {
        model.put("message", "Please Login First!!!");
        return "central/index";
    }
	@Override
    public String getErrorPath() {
        return PATH;
    }

//    @Override
            //   public void run(String... strings) throws Exception {
    //      System.out.println("DATASOURCE = " + dataSource);
    //  }
}