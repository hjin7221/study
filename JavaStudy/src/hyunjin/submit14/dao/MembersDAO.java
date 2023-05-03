package hyunjin.submit14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
	
	
	
	
	
	
}
