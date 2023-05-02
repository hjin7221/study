package hyunjin.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hyunjin.submit13.vo.MemberVO;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	// 회원가입(INSERT) 메소드

	public int registMember(Connection conn, MemberVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO member	 (	 ");
		query.append("      mem_id				 ");
		query.append("    , mem_password		 ");
		query.append("  ) VALUES (				 ");
		query.append("      ?					 ");
		query.append("    , ?				 	 ");
		query.append("  )						 ");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;

		ps.setString(idx++, mem.getMemId());
		ps.setString(idx++, mem.getMemPW());

		int cnt = ps.executeUpdate();

		ps.close();

		return cnt;

	}

	// 멤버 로그인(SELECT) 메소드

	public MemberVO login(Connection conn, MemberVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("		   mem_id				");
		query.append("		 , mem_password as pw	");
		query.append("FROM							");
		query.append("	  member	  				");
		query.append("WHERE 1=1		  				");
		query.append("	 AND mem_id = ?				");
		query.append("	 AND mem_password = ?		");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, mem.getMemId());
		ps.setString(idx++, mem.getMemPW());

		ResultSet rs = ps.executeQuery();

		MemberVO result = new MemberVO();

		while (rs.next()) {
			result.setMemId(rs.getString("mem_id"));
			result.setMemPW(rs.getString("pw"));
		}

		ps.close();
		rs.close();

		return result;

	}

	// 회원 조회
	public ArrayList<MemberVO> getMemList(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("		   mem_id				");
		query.append("		 , mem_password as pw	");
		query.append("FROM							");
		query.append("	  member	  				");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		ResultSet rs = ps.executeQuery();

		ArrayList<MemberVO> result = new ArrayList<>();
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명 일치해야 함.
			String memId = rs.getString("mem_id");
			String memPw = rs.getString("pw");
			MemberVO mem = new MemberVO(memId, memPw);

			result.add(mem);
		}

		ps.close();
		rs.close();

		return result;
	}

}