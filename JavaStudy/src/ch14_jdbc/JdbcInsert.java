package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsert {

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
		
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO students (	 ");
			query.append("      stu_id				 ");
			query.append("    , stu_password		 ");
			query.append("    , stu_name			 ");
			query.append("    , stu_score			 ");
			query.append("  ) VALUES (				 ");
			query.append("      ?					 ");
			query.append("    , ?				 	 ");
			query.append("    , ?			 		 ");
			query.append("    , ?				 	 ");
			query.append("  )						 ");
			
			// 값에 대해 ?로 표기한 후 다음 단계에서 
			// ?에 값을 채워줘도 된다.
			ps = conn.prepareStatement(query.toString());
			
			// 위에서부터 ?를 채워나가며
			// 위에서부터 ?의 인덱스는 1부터 증가한다.
			int idx = 1;
			ps.setString(idx++, "d001");
			ps.setString(idx++, "123d");
			ps.setString(idx++, "칼빵맨");
			ps.setInt(idx++, 60);
			
			// 쿼리문 실행
			// insert,delete, update문은 
			// ps.excuteUpdate()로 실행
			
			// cnt에는 'n행이 삽입 되었습니다.'의 n이 저장된다.
			int cnt = ps.executeUpdate();
			
			System.out.println(cnt + "행 이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 7. 자원 정리 
			if(ps != null) try {ps.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		
		
		
		
		
		
		
		
		
	}

}
