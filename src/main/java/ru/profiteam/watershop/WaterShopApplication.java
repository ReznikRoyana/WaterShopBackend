package ru.profiteam.watershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class WaterShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaterShopApplication.class, args);
	}
}
