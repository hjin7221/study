package ch13_thread;

public class RunStaff implements Runnable{
	private String name;
	private int num;
	
	public RunStaff(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
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
