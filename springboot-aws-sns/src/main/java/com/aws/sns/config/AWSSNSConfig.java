package com.aws.sns.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AWSSNSConfig {

	@Autowired
	private CloudProperties cloudProperties;

	@Primary
	@Bean
	public AmazonSNSClient getSnsClient() {
		return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
				.withCredentials(new AWSStaticCredentialsProvider(
						new BasicAWSCredentials(cloudProperties.getAccessKey(), cloudProperties.getSecretKey())))
				.build();
	}

//	@Bean
//	public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
//		return new QueueMessagingTemplate(amazonSQSAsync);
//	}

	@Bean
	public NotificationMessagingTemplate notificationMessagingTemplate(AmazonSNS amazonSNS) {
		return new NotificationMessagingTemplate(amazonSNS);
	}
}
