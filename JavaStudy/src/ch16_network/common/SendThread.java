package ch16_network.common;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// 연결된 소켓에 내가 입력한 텍스트를 전송
public class SendThread extends Thread {
	private Socket soc;

	public SendThread(Socket soc) {
		this.soc = soc;
	}

	@Override
	public void run() {
		// 키보드로 입력한 텍스트를
		// 소켓의 outputStream에 전송
		Scanner scan = new Scanner(System.in);

		System.out.println("당신의 이름을 입력해주세요.");
		System.out.print(">>> ");
		String name = scan.nextLine();

		try {
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));

			// 연결된 상대방의 소켓에 닉네임 전송
			writer.println(name + "님이 임장하였습니다.");
			// 문구 전송
			writer.flush();

			// 채팅 입력
			while (true) {
				System.out.print(">>> ");
				String msg = scan.nextLine();

				// 채팅종료
				if (msg.equals("") || msg == null || msg.equals("나가기") || msg.equals("exit")) {

					writer.println("대화가 종료되었습니다.");
					writer.flush();
					break;
				}

				writer.println(name + ": " + msg);
				writer.flush();
			}

			soc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
