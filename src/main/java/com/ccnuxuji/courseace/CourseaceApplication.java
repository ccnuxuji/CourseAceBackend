package com.ccnuxuji.courseace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ServletComponentScan
@ConfigurationPropertiesScan
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = {"com.ccnuxuji.courseace.dao", "com.ccnuxuji.courseace.pojo"})
public class CourseaceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CourseaceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CourseaceApplication.class);
	}
}
