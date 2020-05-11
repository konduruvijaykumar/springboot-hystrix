package org.pjay.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author vijayk
 *
 */
@SpringBootApplication
public class SpringbootHystrixService1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHystrixService1Application.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
