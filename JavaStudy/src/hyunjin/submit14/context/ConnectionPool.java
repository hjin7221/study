package hyunjin.submit14.context;

import java.sql.Connection;
import java.util.Vector;

// ConnectionFactory로부터 maxConn 개수만큼
// Connection 객체를 생성해서 보관하고,
// 쿼리물 실행시 보관중인 Connection 객체를
// 빌려주고, 반납받는 클래스
public class ConnectionPool {
	private ConnectionFactory cf = ConnectionFactory.getInstance();
	
	// Vector는 동기화가 적용된 ArrayList와 같다.
	private Vector<Connection> pool = new Vector<>();
	
	private ConnectionPool() {
		//maxConn만큼 Connection 객체를 pool에 담기
		for(int i = 0; i < cf.getMaxConn(); i++) {
			Connection conn = cf.getConnection();
			pool.add(conn);
		}
		System.out.println("pool의 사이즈: " + pool.size());
		System.out.println("Connection 객체를 잘 보관하였습니다.");
	}
	
	private static ConnectionPool instance = new ConnectionPool();
	
	public static ConnectionPool getInstance() {
		return instance;
	}
	
	// pool에 있는 Connection 객체 빌려주기
	public synchronized Connection getConnection() {
		if(pool.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Connection conn = pool.get(0);
		pool.remove(0);
		return conn;
	}
	
	// 빌려준 Connection 객체 반납받기
	
	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		notify();
	}
	
	
	
	
	
	
	
}
