package com.Locktalk.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HandleCorsProblem {

	public 	WebMvcConfigurer corsconfigurer() {
		
		return new WebMvcConfigurer() {
			public void addcorsMappings(CorsRegistry ragistry) { 
				
				ragistry.addMapping("/**")
				.allowedOrigins("https://locktalk13.netlify.app/")
				.allowedMethods("GET","POST","PUT","DELETE")
				.allowedHeaders("*")
				.allowCredentials(true);
			}
		};
	}
}
