package com.elsys.easybooker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
//		org.activiti.spring.boot.SecurityAutoConfiguration.class,
//		org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
})
public class EasybookerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasybookerApplication.class, args);
	}
}
