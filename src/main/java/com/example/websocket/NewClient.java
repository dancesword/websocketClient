package com.example.websocket;

import java.net.URI;
import java.net.URISyntaxException;

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
	}

	@Override
	public void onError(Exception exception) {
		// TODO Auto-generated method stub
		System.out.println("error connection");
	}
	
	
    public static void  mainTest() throws InterruptedException {
    	
//    	String uri = "ws://121.40.165.18:8088";
    	String uri = "ws://127.0.0.1:38080";
    	try {
			NewClient nc = new NewClient(new URI(uri));

			nc.connect();
			
			while(!nc.getReadyState().equals(READYSTATE.OPEN)){
				
				Thread.sleep(2000);
				
				System.out.println("not open yet");

			}
			
//			for (int i = 0; i < 10; i++) {
//	            try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}			
//		    	nc.send("test msg str");
//			}
			nc.send("test msg str");
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
