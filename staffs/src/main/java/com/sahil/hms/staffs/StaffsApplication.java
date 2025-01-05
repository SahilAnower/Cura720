package com.sahil.hms.staffs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class StaffsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffsApplication.class, args);
	}

}
