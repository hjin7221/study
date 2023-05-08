package hyunjin.submit14.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import hyunjin.submit14.context.ConnectionPool;
import hyunjin.submit14.dao.MoneyBookDAO;
import hyunjin.submit14.vo.MoneyBookVO;

public class MoneyBookService {
	
	private MoneyBookService() {}
	
	private static MoneyBookService instance = new MoneyBookService();
	
	public static MoneyBookService getInstance() {
		return instance;
	}
	
	private MoneyBookDAO dao = MoneyBookDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	public ArrayList<MoneyBookVO> showMoneyBookList (MoneyBookVO book) {
		Connection conn = cp.getConnection();
		ArrayList <MoneyBookVO> result = new ArrayList<>();
		
		try {
			result = dao.showMoneyBookList(conn, book);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 가계부 기입 메소드
	
	public void registAccountBook(MoneyBookVO book) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registAccountBook(conn, book);
			System.out.println("추가 완료 하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}
	
	// 원하는 달의 전체내역 보여주기
	public ArrayList<MoneyBookVO> monthAccountList (MoneyBookVO book) {
		Connection conn = cp.getConnection();
		ArrayList <MoneyBookVO> result = new ArrayList<>();
		try {
			result = dao.monthAccountList(conn, book);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 항목별  전체내역 보여주기
	public ArrayList<MoneyBookVO> moneyAccountList (MoneyBookVO book) {
		Connection conn = cp.getConnection();
		ArrayList <MoneyBookVO> result = new ArrayList<>();
		
		try {
			result = dao.moneyAccountList(conn, book);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 항목별 전체내역 보여주기
	public ArrayList<MoneyBookVO> paymentAccountList(MoneyBookVO book) {
		Connection conn = cp.getConnection();
		ArrayList <MoneyBookVO> result = new ArrayList<>();
		
		try {
			result = dao.paymentAccountList(conn, book);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	
}
