package ch16_network.client;

import java.io.IOException;
import java.net.Socket;

import ch16_network.common.ReceiveThread;
import ch16_network.common.SendThread;

public class ChatClient {

	public static void main(String[] args) {
		// 소켓 통신의 클라이언트 단
		
		// 서버 소켓에 연결할 소켓 객체 생성
		// 생성자에 서버소켓의 ip와 포트번호를 넣어준다.
		try {
			Socket clientSocket = new Socket("192.168.1.29", 5001);
			System.out.println("접속 성공");
			System.out.println(clientSocket.getRemoteSocketAddress());
			
			SendThread send = new SendThread(clientSocket);
			send.start();
			ReceiveThread receive = new ReceiveThread(clientSocket);
			receive.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
