package com.example.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsocketClientApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(WebsocketClientApplication.class, args);
		
//		try {
//			LogHandlerService.createConnect();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
}
