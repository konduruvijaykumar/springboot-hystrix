package org.pjay.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
//https://spring.io/blog/2016/10/27/spring-tips-circuit-breakers
//URL for dashboard is http://localhost:8383/hystrix
public class SpringbootHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHystrixDashboardApplication.class, args);
	}

}
