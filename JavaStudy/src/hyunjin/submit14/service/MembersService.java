package hyunjin.submit14.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import hyunjin.submit14.context.ConnectionPool;
import hyunjin.submit14.dao.MembersDAO;
import hyunjin.submit14.vo.MembersVO;

public class MembersService {
	
	private MembersService () {}
	
	private static MembersService instance = new MembersService();
	
	public static MembersService getInstance() {
		return instance;
	}
	
	private MembersDAO dao = MembersDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	// 회원가입 메소드
	public void registMembers( MembersVO mem) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registMembers(conn, mem);
			System.out.println(mem.getMem_name() + "님 회원가입에 성공하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}
	
	// 로그인 메소드
	public MembersVO login (MembersVO mem) {
		Connection conn = cp.getConnection();
		MembersVO result = new MembersVO();
		try {
			result = dao.login(conn, mem);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 회원목록 조회
	public ArrayList<MembersVO> showMembersList () {
		Connection conn = cp.getConnection();
		ArrayList<MembersVO> result = new ArrayList<>();
		
		try {
			result = dao.showMembersList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 아이디 찾기 조회
	public MembersVO findId (MembersVO mem) {
		Connection conn = cp.getConnection();
		MembersVO result = new MembersVO();
		
		try {
			result = dao.findId(conn, mem);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	//비밀번호 찾기 메소드 1단계
	public MembersVO findPw (MembersVO mem) {
		Connection conn = cp.getConnection();
		MembersVO result = new MembersVO();
		
		try {
			result = dao.findPw(conn, mem);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 비밀번호 찾기 메소드 2단계 
	public MembersVO findPw2 (MembersVO mem) {
		Connection conn = cp.getConnection();
		MembersVO result = new MembersVO();
		
		try {
			result = dao.findPw2(conn, mem);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 비밀번호 재설정 메소드
	public void resetPw(MembersVO mem) {
		Connection conn = cp.getConnection();
		
		try {
			dao.resetPw(conn, mem);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}
	
}
