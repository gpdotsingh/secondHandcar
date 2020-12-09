package com.cogizant.test.secondhandcar;

import com.cogizant.test.secondhandcar.entity.Example;
import com.cogizant.test.secondhandcar.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@SpringBootApplication
public class SecondhandCarApplication {

	Util util;

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
