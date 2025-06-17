package com.teleradms.hospital.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HospitalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalServiceApplication.class, args);
	}

}
