package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTransaction {

	/*
	 * 한번 실행할때마다 준호씨가 동욱씨한테 월급 250만원을 송금한다. (준호씨 계좌 -250만원, 동욱씨 계좌 +250만원)
	 * 
	 * 이처럼 하나의 기능에 대해 여러개의 쿼리문이 실행되는 경우 모든 쿼리문이 안전하게 실행된 후 
	 * 커밋을 하고 도중에 에러 발생시 롤백을 하는
	 * 것이 트랜잭션(Transaction)이다.
	 * 
	 * 만약 준호씨 계좌에서 250만원을 뺐더니 잔액이 0원 이하가 된다면 없었던일로 하고 롤백시킨다.
	 * 
	 */
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 등록 실패");
			System.exit(0); // 현재 프로그램 종료
		}

		String url = "jdbc:oracle:thin:@192.168.1.40:1521:xe";
		String id = "jdbc";
		String pw = "oracle";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, id, pw);

			// 자동으로 커밋되는 옵션 끄기
			// (기본값: 자동커밋)
			conn.setAutoCommit(false);

			// 이후 모든 쿼리문들이 전부 안전하게 실행이
			// 종료된 다음 수동으로 커밋

			StringBuffer query = new StringBuffer();
			query.append("UPDATE 			 						");
			query.append("		bank 	 							");
			query.append("SET			 							");
			query.append("    bank_money = bank_money + ?			");
			query.append("WHERE	1=1									");
			query.append("    AND bank_account = ?					");

			ps = conn.prepareStatement(query.toString());

			int idx = 1;
			ps.setInt(idx++, -2500000);
			ps.setString(idx++, "123-0000-45");

			int cnt = ps.executeUpdate();

			if (cnt > 0) {
				// 정상 실행
				System.out.println("준호씨의 계좌에서 250만원이 인출되었습니다.");
				// SELECT 문으로 준호씨의 계좌 금액을 꺼내오기

				query = new StringBuffer();
				query.append("SELECT					");
				query.append("		   bank_money		");
				query.append("FROM						");
				query.append("	  bank	  				");
				query.append("WHERE 1=1	  				");
				query.append("  AND bank_account = ? 	");

				ps.close();
				ps = conn.prepareStatement(query.toString());

				ps.setString(1, "123-0000-45");

				rs = ps.executeQuery();

				int money = 0;
				while (rs.next()) {
					money = rs.getInt("bank_money");
				}
				System.out.println("준호씨 계좌 잔액: " + money);

				if (money > 0) {
					// 정상
					// 동욱씨 계좌에 250만원 추가
					query = new StringBuffer();
					query.append("UPDATE 			 						");
					query.append("		bank 	 							");
					query.append("SET			 							");
					query.append("    bank_money = bank_money + ?			");
					query.append("WHERE	1=1									");
					query.append("    AND bank_account = ?					");

					ps.close();
					ps = conn.prepareStatement(query.toString());

					idx = 1;
					ps.setInt(idx++, 2500000);
					ps.setString(idx++, "321-0000-54");

					cnt = ps.executeUpdate();

					if (cnt > 0) {
						// 정상 ( 모든 과정이 안전하게 종료된 시점)
						System.out.println("동욱씨의 계좌에 월급이 들어왔습니다. ");

						// 커밋
						conn.commit();

						// DB의 동욱씨 계좌 잔액 꺼내와서 출력

						query = new StringBuffer();
						query.append("SELECT					");
						query.append("		   bank_money		");
						query.append("FROM						");
						query.append("	  bank	  				");
						query.append("WHERE 1=1	  				");
						query.append("  AND bank_account = ? 	");

						ps.close();
						ps = conn.prepareStatement(query.toString());

						ps.setString(1, "321-0000-54");

						rs.close();
						rs = ps.executeQuery();

						money = 0;
						while (rs.next()) {
							money = rs.getInt("bank_money");
						}
						System.out.println("동욱씨 계좌 잔액: " + money);
					} else {
						// 문제발생
						// 롤백
						conn.rollback();
					}
				} else {
					// 돈 부족, 없었던 일로
					// 롤백
					System.out.println("준호: 이번달 월급은 없었던 일로..");
					conn.rollback();
				}
			} else {
				// 문제 발생
				// 롤백
				System.out.println("준호씨의 계좌에서 돈을 인출하는 과정에서 문제 발생");
				conn.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// 에러 발생시 롤백
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 7. 자원 정리
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
