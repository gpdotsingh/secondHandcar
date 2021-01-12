package com.cogizant.test.secondhandcar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@SpringBootApplication
public class SecondhandCarApplication {
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(SecondhandCarApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
