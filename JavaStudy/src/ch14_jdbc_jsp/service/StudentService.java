package ch14_jdbc_jsp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import ch14_jdbc_jsp.dao.StudentDAO;
import ch14_jdbc_jsp.vo.StudentVO;

public class StudentService {
	
	private StudentService() {}
	
	private static StudentService instance = new StudentService();
	
	public static StudentService getInstance () {
		return instance;
	}
	
	private StudentDAO dao = StudentDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	// 회원목록 조회(SELECT) 메소드
	public ArrayList<StudentVO> getStuList() {
		Connection conn = cp.getConnection();
		ArrayList<StudentVO> result = new ArrayList<>();
		
		try {
			result = dao.getStuList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		
		return result;
	}
	// 학생 회원가입 (INSERT) 메소드 \
	public void registStudent (String id, String pw, String name) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registStudent(conn, id,pw,name);
			System.out.println("회원가입에 성공하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		

		
		
		
	}
	// 학생 회원가입 (INSERT) 메소드 \
	public void registStudent (StudentVO student) {
		Connection conn = cp.getConnection();

		
		try {
			dao.registStudent(conn, student);
			System.out.println("회원가입에 성공하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		
	}
	
	
	// 로그인(SELECT) 메소드
	public StudentVO login (StudentVO student) {
		Connection conn = cp.getConnection();
		StudentVO result = new StudentVO();
		try {
			result = dao.login(conn, student);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 학생 점수 증가 메소드
	public void plusScore(String stuId) {
		Connection conn = cp.getConnection();
		
		try {
			dao.plusScore(conn, stuId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}
	
	
	
	
	
}
