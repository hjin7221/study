package hyunjin.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import hyunjin.submit13.dao.MemberDAO;
import hyunjin.submit13.vo.MemberVO;

public class MemberService {

	private MemberService() {
	}

	private static MemberService instance = new MemberService();

	public static MemberService getInstance() {
		return instance;
	}

	private MemberDAO dao = MemberDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	// 회원가입(INSERT) 메소드

	public void registMember(MemberVO mem) {
		try {
			dao.registMember(cp.getConnection(), mem);
			System.out.println("회원가입이 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(cp.getConnection());
		}
	}

	// 멤버 로그인(SELECT) 메소드

	public MemberVO login(MemberVO mem) {
		Connection conn = cp.getConnection();
		MemberVO result = new MemberVO();

		try {
			result = dao.login(conn, mem);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}

	public ArrayList<MemberVO> getMemList() {
		Connection conn = cp.getConnection();
		ArrayList<MemberVO> result = new ArrayList<>();
		try {
			result = dao.getMemList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}

}
