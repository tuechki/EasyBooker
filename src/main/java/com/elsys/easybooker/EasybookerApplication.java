package com.elsys.easybooker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.PostConstruct;

@CrossOrigin(origins = "localhost:4200")
@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
//		org.activiti.spring.boot.SecurityAutoConfiguration.class,
//		org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
})
public class EasybookerApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Configuration
//	public static class PathMatchingConfigurationAdapter extends WebMvcConfigurerAdapter {
//
//		@Override
//		public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//			configurer.favorPathExtension(false);
//		}
//	}

//	@Configuration
//	public class WebConfiguration extends WebMvcConfigurationSupport {
//
//		@Override
//		public void addResourceHandlers(ResourceHandlerRegistry registry){
//			registry.addResourceHandler("/**")
//					.addResourceLocations("classpath:/static/");
//		}
//	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/users").allowedOrigins("http://localhost:4200");
			}
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(EasybookerApplication.class, args);
	}

	@Autowired
	private ObjectMapper objectMapper;

	@PostConstruct
	public void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
	}
}
