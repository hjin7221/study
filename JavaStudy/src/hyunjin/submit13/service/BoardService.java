package hyunjin.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import hyunjin.submit13.dao.BoardDAO;
import hyunjin.submit13.vo.BoardVO;

public class BoardService {
	private BoardService () {}
	
	private static BoardService instance = new BoardService();
	
	public static BoardService getInstance() {
		return instance;
	}
	
	BoardDAO dao = BoardDAO.getInstance();
	ConnectionPool cp = ConnectionPool.getInstance();
	
	//게시글 목록(SELECT) 가져오기
	
	public ArrayList<BoardVO> showBoardList() {
		Connection conn = cp.getConnection();
		
		ArrayList<BoardVO> result = new ArrayList<>();
		
		try {
			result = dao.showBoardList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 글쓰기 (INSERT) 메소드
	
	public void registWriting(BoardVO board) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registWriting(conn, board);
			System.out.println("글이 작성되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
	}
		
	
}
