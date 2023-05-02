package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDelete {

	public static void main(String[] args) {
		// 1. 드라이버 로딩
		// (프로젝트 내에서 단 한번만 실행이 되면 됨)
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

			StringBuffer query = new StringBuffer();
			query.append("DELETE 			 				");
			query.append("		students 	 				");
			query.append("WHERE	1=1							");
			query.append("    AND stu_id = ?				");

			// 값에 대해 ?로 표기한 후 다음 단계에서
			// ?에 값을 채워줘도 된다.
			ps = conn.prepareStatement(query.toString());

			// 위에서부터 ?를 채워나가며
			// 위에서부터 ?의 인덱스는 1부터 증가한다.
			int idx = 1;
			ps.setString(idx++, "d001");

			// 쿼리문 실행
			// insert,delete, update문은
			// ps.excuteUdate()로 실행

			// cnt에는 'n행이 삽입 되었습니다.'의 n이 저장된다.
			int cnt = ps.executeUpdate();

			System.out.println(cnt + "행 이(가) 삭제되었습니다.");

			// 업데이트문 실행 후 SELECT문 실행하여
			// 변경사항 확인

			query = new StringBuffer();
			query.append("SELECT						");
			query.append("		   stu_id				");
			query.append("		 , stu_password as pw	");
			query.append("		 , stu_name				");
			query.append("		 , stu_score			");
			query.append("FROM							");
			query.append("	  students	  				"); // 세미콜론이 없음에 주의

			// 사용했던 ps는 한번 닫아준 뒤 사용
			ps.close();
			ps = conn.prepareStatement(query.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				// 쿼리문 실행 결과에 해당하는 컬럼명 일치해야 함.
				String stuId = rs.getString("stu_id");
				String stuPw = rs.getString("pw");
				String stuName = rs.getString("stu_name");
				int stuScore = rs.getInt("stu_score");

				System.out.println("아이디: " + stuId + " 비밀번호: " + stuPw + " 이름: " + stuName + " 점수: " + stuScore);

			}

		} catch (SQLException e) {
			e.printStackTrace();
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