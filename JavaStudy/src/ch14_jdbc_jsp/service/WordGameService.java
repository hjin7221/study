package ch14_jdbc_jsp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import ch14_jdbc_jsp.dao.WordGameDAO;
import ch14_jdbc_jsp.vo.WordGameVO;

public class WordGameService {
	
	private WordGameService () {}
	
	private static WordGameService instance = new WordGameService();
	
	public static WordGameService getInstnace() {
		return instance;
	}
	
	private WordGameDAO dao = WordGameDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	public ArrayList<WordGameVO> getWordList() {
		Connection conn = cp.getConnection();
		ArrayList<WordGameVO> result = new ArrayList<>();
		
		try {
			result =  dao.getWordList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		
		return result;
	}
	
	
	
	
	
	
}
