package com.bastelbude.timeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class TimelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimelineApplication.class, args);
	}

	@Autowired
	public void listConfigurers(List<WebMvcConfigurer> configurers) {
		System.out.println("WebMvcConfigurers: " + configurers);
	}
}
