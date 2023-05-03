package hyunjin.submit14.service;

import java.sql.Connection;
import java.sql.SQLException;

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
	
}
