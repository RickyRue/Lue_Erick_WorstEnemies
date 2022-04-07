package com.erick.lue.casestudy.worstenemies;

import com.erick.lue.casestudy.worstenemies.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CaseStudyWorstEnemiesApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(CaseStudyWorstEnemiesApplication.class, args);
		UserService userService = applicationContext.getBean(UserService.class);
	}

}
