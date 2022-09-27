package com.dbtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DbtestApplication {


	@GetMapping("/")
	public String home(){
		return "bruh toast yoseph tats";
	}

	public static void main(String[] args) {
		SpringApplication.run(DbtestApplication.class, args);
	}

}
