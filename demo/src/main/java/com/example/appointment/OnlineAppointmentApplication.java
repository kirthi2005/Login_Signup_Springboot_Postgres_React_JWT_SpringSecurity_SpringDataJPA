package com.example.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class  OnlineAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineAppointmentApplication.class, args);
	}
	/*@Bean
	public WebMvcConfigurer corsConfigurer(){
		return addCorsMappings(registry)->{
			registry.addMapping("/ws/**")
					.allowedOrigins("http://localhost:5173")
					.allowedMethods("GET","POST")
					.allowedCredentials(true);

		}*/



}
