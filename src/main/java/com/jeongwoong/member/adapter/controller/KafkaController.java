package com.jeongwoong.member.adapter.controller;

import com.jeongwoong.member.kafka.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/kafka")
@RequiredArgsConstructor
@RestController
public class KafkaController {

	private final ProducerService producerService;

	@GetMapping("/send")
	public void send(@RequestParam String message) {
		producerService.sendMessage(message);
	}

}
