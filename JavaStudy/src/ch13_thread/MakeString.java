package ch13_thread;

public class MakeString {

	public static void main(String[] args) {
		// 문자열을 아주 길~~~~~~~~~~~게 만들어보자

		StringBuffer strBuff = new StringBuffer();
		StringBuilder strBuild = new StringBuilder();

		Thread jonghyun = new Thread(() -> {
			for (int i = 0; i < 50000000; i++) {
				strBuild.append(1);
			}
			System.out.println(strBuild.length());
		});

		Thread seoyoung = new Thread(() -> {
			for (int i = 0; i < 50000000; i++) {
				strBuild.append(1);
			}
			System.out.println(strBuild.length());
		});

		jonghyun.start();
		seoyoung.start();

		System.out.println(strBuild.length());

	}

}