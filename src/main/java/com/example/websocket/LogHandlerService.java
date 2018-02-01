package com.example.websocket;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.java_websocket.WebSocket;

import com.example.websocket.NewClient;


public class LogHandlerService implements Runnable{

	// 缓存队列，存放待传输日志
	public static ConcurrentLinkedQueue<String> logQueue;
	
	public LogHandlerService(ConcurrentLinkedQueue<String> logQueue){
		this.logQueue = logQueue;
	}
	
    public static NewClient createConnect() throws InterruptedException {
    	
    	String uri = "ws://127.0.0.1:38080";
    	
    	try {
			NewClient nc = new NewClient(new URI(uri));
            
			// 创建连接
			nc.connect();
			
			// 确保连接建立
			while(!nc.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
				System.out.println("not open yet");
			}
			
			// 返回此对象
			return nc;
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
	}
    
    public void sendMsgToServer(NewClient nc){
    	if (null == logQueue || logQueue.size() == 0) {
			return;
		}
    	
    	for (int i = 0; i < logQueue.size(); i++) {
    		String sendStr = logQueue.poll();
    		nc.send(sendStr);
		}
    }

	@Override
	public void run() {
		
		try {
			// 创建连接
			NewClient client = createConnect();
			// 根据返回的client对象，发送记录
			sendMsgToServer(client);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
