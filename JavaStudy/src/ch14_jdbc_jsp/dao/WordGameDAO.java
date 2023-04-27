package ch14_jdbc_jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.vo.WordGameVO;

public class WordGameDAO {
	
	private WordGameDAO() {}
	
	private static WordGameDAO instance = new WordGameDAO();
	
	public static WordGameDAO getInstance() {
		return instance;
	}
	
	// 단어 목록(SELECT) 가져오기 
	public ArrayList<WordGameVO> getWordList(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT 				");
		query.append("	  words				");
		query.append("FROM					");
		query.append("	  wordgame			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<WordGameVO> result = new ArrayList<>();
		
		while(rs.next()) {
			WordGameVO temp = new WordGameVO();
			temp.setWords(rs.getString("words"));
			result.add(temp);
		}
		
		rs.close();
		ps.close();
		
		return result;
	}
	
	
}
