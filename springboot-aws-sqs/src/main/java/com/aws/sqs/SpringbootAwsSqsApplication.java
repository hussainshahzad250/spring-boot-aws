package com.aws.sqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;

@EnableSqs
@SpringBootApplication(exclude = { ContextStackAutoConfiguration.class })
public class SpringbootAwsSqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsSqsApplication.class, args);
	}

}
