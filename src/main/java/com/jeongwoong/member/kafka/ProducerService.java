package com.jeongwoong.member.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProducerService {

	private static final String TOPIC = "member-events";
	private final KafkaTemplate<String, Object> kafkaTemplate;

	public void	sendMessage(String message) {
		log.info("Producing message: {}", message);
		kafkaTemplate.send(TOPIC, message);
	}

}
