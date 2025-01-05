package com.sahil.hms.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes (RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(r -> r
						.path("/curahms/patients/**")
						.filters(f -> f.rewritePath("/curahms/patients/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", new Date().toString()))
						.uri("lb://PATIENTS"))
				.route(r -> r
						.path("/curahms/staffs/**")
						.filters(f -> f.rewritePath("/curahms/staffs/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", new Date().toString()))
						.uri("lb://STAFFS"))
				.route(r -> r
						.path("/curahms/appointments/**")
						.filters(f -> f.rewritePath("/curahms/appointments/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", new Date().toString()))
						.uri("lb://APPOINTMENTS"))
				.build();
	}

}
