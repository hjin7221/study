package hyunjin.submit14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import hyunjin.submit14.vo.MembersVO;

public class MembersDAO {
	
	private MembersDAO() {}
	
	private static MembersDAO instance = new MembersDAO();
	
	public static MembersDAO getInstance() {
		return instance;
	}
	
	
	// 회원가입 메소드
	
	public int registMembers(Connection conn, MembersVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO members ( 		");
		query.append("		mem_id			 		");
		query.append("	   ,mem_pw			 		");
		query.append("	   ,mem_name		 		");
		query.append("	   ,hint_question	 		");
		query.append("	   ,hint_answer		 		");
		query.append("	   ,create_date		 		");
		query.append("	 ) VALUES (			 		");
		query.append("	   		?			 		");
		query.append("	   	  , ?			 		");
		query.append("	   	  , ?			 		");
		query.append("	   	  , ?			 		");
		query.append("	   	  , ?			 		");
		query.append("	   	  , ?			 		");
		query.append("	   )				 		");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		String strToday = sdf.format(today);
		
		int idx = 1;
		ps.setString(idx++, mem.getMem_id());
		ps.setString(idx++, mem.getMem_pw());
		ps.setString(idx++, mem.getMem_name());
		ps.setString(idx++, mem.getHint_question());
		ps.setString(idx++, mem.getHint_answer());
		ps.setString(idx++, strToday);
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
		
	}
	
	// 로그인 (SELECT) 메소드
	
	public MembersVO login (Connection conn, MembersVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT   					");
		query.append("		 mem_id				");
		query.append("	   , mem_pw				");
		query.append("	   , mem_name			");
		query.append("	   , hint_question		");
		query.append("	   , hint_answer		");
		query.append("	   , create_date		");
		query.append("FROM   					");
		query.append("		 members			");
		query.append("WHERE 1=1					");
		query.append("		 AND mem_id = ?		");
		query.append("		 AND mem_pw = ?		");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, mem.getMem_id());
		ps.setString(idx++, mem.getMem_pw());
		
		ResultSet rs = ps.executeQuery();
		
		MembersVO result = new MembersVO();
		
		while(rs.next()) {
			result.setMem_id(rs.getString("mem_id"));
			result.setMem_pw(rs.getString("mem_pw"));
			result.setMem_name(rs.getString("mem_name"));
			result.setHint_question(rs.getString("hint_question"));
			result.setHint_answer(rs.getString("hint_answer"));
			result.setCreate_date(rs.getString("create_date"));
		}
		rs.close();
		ps.close();
		
		return result;
	}
	
	// 회원목록(SELECT) 확인
	
	public ArrayList<MembersVO> showMembersList (Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT   					");
		query.append("		 mem_id				");
		query.append("	   , mem_pw				");
		query.append("	   , mem_name			");
		query.append("	   , hint_question		");
		query.append("	   , hint_answer		");
		query.append("	   , create_date		");
		query.append("FROM   					");
		query.append("		 members			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());

		ResultSet rs = ps.executeQuery();
		
		ArrayList<MembersVO> result = new ArrayList<>();
		
		while(rs.next()) {
			String memId = rs.getString("mem_id");
			String memPw = rs.getString("mem_pw");
			String memNm = rs.getString("mem_name");
			String memHintQ = rs.getString("hint_question");
			String memHintA = rs.getString("hint_answer");
			String memCreDate = rs.getString("create_date");
			
			MembersVO mems = new MembersVO(memId, memPw,memNm,memHintQ,memHintA,memCreDate);
			
			result.add(mems);
		}
		rs.close();
		ps.close();
		
		return result;
	}
	
	// 아이디 찾기 메소드
	
	public MembersVO findId (Connection conn, MembersVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT   					");
		query.append("		 mem_id				");
		query.append("		,mem_name			");
		query.append("FROM   					");
		query.append("		 members			");
		query.append("WHERE 1=1					");
		query.append("		 AND mem_name = ?	");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());

		ps.setString(1, mem.getMem_name());
		
		ResultSet rs = ps.executeQuery();
		
		MembersVO result = new MembersVO();
		
		while(rs.next()) {
			result.setMem_id(rs.getString("mem_id"));
			result.setMem_name(rs.getString("mem_name"));
		}
		rs.close();
		ps.close();
		
		return result;
	}
	
	// 비밀번호 찾기 메소드 1단계 
	public MembersVO findPw (Connection conn, MembersVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT   					");
		query.append("		 mem_id				");
		query.append("		,mem_name			");
		query.append("		,hint_question		");
		query.append("		,hint_answer		");
		query.append("FROM   					");
		query.append("		 members			");
		query.append("WHERE 1=1					");
		query.append("	AND mem_id = ?			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ps.setString(1, mem.getMem_id());
		
		ResultSet rs = ps.executeQuery();
		
		MembersVO result = new MembersVO();
		
		while(rs.next()) {
			result.setMem_id(rs.getString("mem_id"));
			result.setMem_name(rs.getString("mem_name"));
			result.setHint_question(rs.getString("hint_question"));
			result.setHint_answer(rs.getString("hint_answer"));
		}
		rs.close();
		ps.close();
		
		return result;
	} 
	
	// 비밀번호 찾기 메소드 2단계 
	public MembersVO findPw2 (Connection conn, MembersVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT   					");
		query.append("		 mem_id				");
		query.append("		,mem_name			");
		query.append("		,hint_question		");
		query.append("		,hint_answer		");
		query.append("FROM   					");
		query.append("		 members			");
		query.append("WHERE 1=1					");
		query.append("	AND mem_id = ?			");
		query.append("	AND hint_answer = ?		");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, mem.getMem_id());
		ps.setString(idx++, mem.getHint_answer());
		
		ResultSet rs = ps.executeQuery();
		
		MembersVO result = new MembersVO();
		
		while(rs.next()) {
			result.setMem_id(rs.getString("mem_id"));
			result.setMem_name(rs.getString("mem_name"));
			result.setHint_question(rs.getString("hint_question"));
			result.setHint_answer(rs.getString("hint_answer"));
		}
		rs.close();
		ps.close();
		
		return result;
	} 
	
	// 비밀번호 재설정 메소드
	public int resetPw(Connection conn , MembersVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE					");
		query.append("		 members			");
		query.append("SET						");
		query.append("	mem_pw = ?				");
		query.append("WHERE 1=1					");
		query.append("	AND hint_answer = ?		");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, mem.getMem_pw());
		ps.setString(idx++, mem.getHint_answer());
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
	}
	
}
