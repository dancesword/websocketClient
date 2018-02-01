package com.example.websocket;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class NewClient extends WebSocketClient{
	
	public NewClient(URI serverUri) {
		super(serverUri);
	}


	@Override
	public void onOpen(ServerHandshake serverhandshake) {
		
		System.out.println("client open connection");
		
		
	}

	@Override
	public void onMessage(String s) {
		
		System.out.println("test message" + s);
	}

	@Override
	public void onClose(int i, String s, boolean flag) {
		
		System.out.println("close connection");
		
		// 服务端异常中断处理方法
		
	}

	@Override
	public void onError(Exception exception) {
		// TODO Auto-generated method stub
		System.out.println("error connection");
	}

}
