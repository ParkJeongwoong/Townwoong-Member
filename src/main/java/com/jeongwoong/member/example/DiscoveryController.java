package com.jeongwoong.member.example;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/discovery")
@RequiredArgsConstructor
@RestController
public class DiscoveryController {

	private final DiscoveryService discoveryService;

	@GetMapping("/services")
	public List<String> services(@RequestHeader("X-Gateway-Header") String token) {
		System.out.println("Token: " + token);
		return discoveryService.services();
	}

	@GetMapping("/direct/services")
	public List<String> directServices() {
		return discoveryService.services();
	}

}
