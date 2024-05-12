package com.jeongwoong.member.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsumerService {

	private static final String TOPIC = "member-events";

	@KafkaListener(topics = TOPIC, groupId = "member-group")
	public void consume(String message) {
		System.out.println("Consumed message: " + message);
	}

}
