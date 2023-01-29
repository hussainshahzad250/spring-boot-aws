package com.aws.sqs.listner;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class QueueConsumer {
	@SqsListener(value = "test_queue")
	public void loadMessageFromSQS(String message) {
		log.info("message from SQS Queue {}", message);
	}
}
