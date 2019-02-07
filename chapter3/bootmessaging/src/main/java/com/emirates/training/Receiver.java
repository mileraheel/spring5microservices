package com.emirates.training;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
class Receiver {
	@RabbitListener(queues = "TestQ")
	public void processMessage(String content) {
		System.out.println(content);
	}
}