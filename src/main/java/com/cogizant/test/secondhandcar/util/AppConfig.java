package com.cogizant.test.secondhandcar.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.properties")
@Data
public class AppConfig {

	@Value("${cs.cars.url}")
	private String url;
}
