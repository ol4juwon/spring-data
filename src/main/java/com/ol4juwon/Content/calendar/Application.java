package com.ol4juwon.Content.calendar;

import com.ol4juwon.Content.calendar.config.CCProperties;
import com.ol4juwon.Content.calendar.models.Content;
import com.ol4juwon.Content.calendar.models.Status;
import com.ol4juwon.Content.calendar.models.Type;
import com.ol4juwon.Content.calendar.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
@EnableConfigurationProperties(CCProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		System.out.println(restTemplate);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(ContentRepository repository){
//		return args -> {
//			Content c = new Content(
//					null,
//					"JSh Spring",
//					"GhI",
//					Status.IDEA,
//					Type.ARTICLE,
//					LocalDateTime.now(),
//					null,
//					""
//			);
//			repository.save(c);
//		};
//	}

}
