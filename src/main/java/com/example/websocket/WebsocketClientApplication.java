package com.example.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsocketClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketClientApplication.class, args);
		
		
		try {
			NewClient.mainTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
