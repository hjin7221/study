package ch13_thread;

public class MyStaff extends Thread {
	private int num;
	private String name;

	public MyStaff(int num, String name) {
		this.num = num;
		this.name = name;
	}

	// 이 스레드에 맡길 업무 설정
	// run 메소드 오버라이드
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + num++);

			try {
				// 현재 이 코드를 실행중인 스레드가 멈추는 것.
				// 다른 스레드는 영향을 받지 않는다.
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
