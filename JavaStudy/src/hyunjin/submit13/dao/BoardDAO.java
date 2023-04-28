package hyunjin.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ch14_jdbc_jsp.vo.StudentVO;
import hyunjin.submit13.vo.BoardVO;
import hyunjin.submit13.vo.MemberVO;

public class BoardDAO {

	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	// 게시글 목록(SELECT) 가져오기

	public ArrayList<BoardVO> showBoardList(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT 				");
		query.append("	  no				");
		query.append("	 ,title				");
		query.append("	 ,mem_id			");
		query.append("	 ,create_date		");
		query.append("FROM					");
		query.append("	  board				");
		query.append("ORDER BY no DESC		");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		ResultSet rs = ps.executeQuery();

		ArrayList<BoardVO> result = new ArrayList<>();

		while (rs.next()) {
			BoardVO temp = new BoardVO();
			temp.setNo(rs.getInt("no"));
			temp.setTitle(rs.getString("title"));
			temp.setAuthor(rs.getString("mem_id"));
			temp.setCreate_date(rs.getString("create_date"));
			result.add(temp);
		}

		rs.close();
		ps.close();

		return result;
	}

	// 글쓰기 (INSERT) 메소드

	public int registWriting(Connection conn, BoardVO board) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO  board (		 ");
		query.append("      no					 ");
		query.append("    , title				 ");
		query.append("    , mem_id				 ");
		query.append("    , create_date			 ");
		query.append("    , contents			 ");
		query.append("  ) VALUES (				 ");
		query.append("      ?					 ");
		query.append("    , ?				 	 ");
		query.append("    , ?			 		 ");
		query.append("    , ?				 	 ");
		query.append("    , ?				 	 ");
		query.append("  )						 ");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		String strToday = sdf.format(today);
		int idx = 1;
		ps.setInt(idx++, showBoardList(conn).size() + 1);
		ps.setString(idx++, board.getTitle());
		ps.setString(idx++, board.getAuthor());
		ps.setString(idx++, strToday);
		ps.setString(idx++, board.getContents());

		int cnt = ps.executeUpdate();

		ps.close();

		return cnt;

	}

}
