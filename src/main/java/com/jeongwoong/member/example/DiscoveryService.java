package com.jeongwoong.member.example;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DiscoveryService {

	private final DiscoveryClient discoveryClient;

	public List<String> services() {
		List<String> services = new ArrayList<>();

		discoveryClient.getServices().forEach(serviceName -> {
			discoveryClient.getInstances(serviceName).forEach(instance -> {
				services.add(String.format("%s:%s", serviceName, instance.getUri()));
			});
		});
		return services;
	}

}
