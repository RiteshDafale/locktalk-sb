package com.Locktalk.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HandleCorsProblem {

	@Bean
	public 	WebMvcConfigurer corsconfigurer() {
		
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry ragistry) { 
				 
				ragistry.addMapping("/**")
				.allowedOrigins("https://locktalk13.netlify.app/")
				.allowedMethods("GET","POST","PUT","DELETE")
				.allowedHeaders("*")
				.allowCredentials(true);
			}
		};
	}
}
