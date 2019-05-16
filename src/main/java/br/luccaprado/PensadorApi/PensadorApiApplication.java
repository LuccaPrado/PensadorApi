package br.luccaprado.PensadorApi;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class PensadorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensadorApiApplication.class, args);

	}

}

