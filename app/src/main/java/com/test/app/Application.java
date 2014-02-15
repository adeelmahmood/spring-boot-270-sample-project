package com.test.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class Application implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args){
    	SpringApplication app = new SpringApplication(Application.class);
    	app.setShowBanner(false);
    	app.run(args);
    }  
	
	@Override
	public void run(String... arg0) throws Exception {
		log.debug("application started");
		
		ClassPathResource resource = new ClassPathResource("test.properties");
		log.debug("resource loaded " + resource);
	}
}