package hyunjin.submit14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ch14_jdbc_jsp.vo.StudentVO;
import hyunjin.submit14.vo.MembersVO;
import hyunjin.submit14.vo.MoneyBookVO;

public class MoneyBookDAO {

	private MoneyBookDAO() {
	}

	private static MoneyBookDAO instance = new MoneyBookDAO();

	public static MoneyBookDAO getInstance() {
		return instance;
	}

	// 이달, 사용자별 의 카테고리별 금액 총계 보여주기
	public ArrayList<MoneyBookVO> showMoneyBookList(Connection conn, MoneyBookVO book) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT   							");
		query.append("	     gubun as 구분				");
		query.append("	   , sum(account) as 총합		");
		query.append("FROM   							");
		query.append("		 moneybook					");
		query.append("WHERE 1=1							");
		query.append("	AND mem_id = ?					");
		query.append("	AND substr(use_date,4,2) = ?	");
		query.append("GROUP BY gubun					");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		String strToday = sdf.format(today);
		int idx = 1;
		ps.setString(idx++, book.getMem_id());
		ps.setString(idx++, strToday.substring(3, 5));

		ResultSet rs = ps.executeQuery();

		ArrayList<MoneyBookVO> result = new ArrayList<>();

		while (rs.next()) {
			String gubun = rs.getString("구분");
			int accountTotal = rs.getInt("총합");

			MoneyBookVO money = new MoneyBookVO();
			money.setGubun(gubun);
			money.setAccount(accountTotal);

			result.add(money);
		}
		rs.close();
		ps.close();

		return result;
	}

	// 가계부 기입 메소드

	public int registAccountBook(Connection conn, MoneyBookVO book) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO moneybook (		 ");
		query.append("      use_date				 ");
		query.append("    , mem_id					 ");
		query.append("    , gubun					 ");
		query.append("    , money_category			 ");
		query.append("    , account					 ");
		query.append("    , payment_category		 ");
		query.append("    , contents				 ");
		query.append("  ) VALUES (					 ");
		query.append("      ?						 ");
		query.append("    , ?				 		 ");
		query.append("    , ?			 			 ");
		query.append("    , ?			 			 ");
		query.append("    , ?			 			 ");
		query.append("    , ?			 			 ");
		query.append("    , ?			 			 ");
		query.append("  )							 ");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, book.getUse_date());
		ps.setString(idx++, book.getMem_id());
		ps.setString(idx++, book.getGubun());
		ps.setString(idx++, book.getMoney_category());
		ps.setInt(idx++, book.getAccount());
		ps.setString(idx++, book.getPayment_category());
		ps.setString(idx++, book.getContents());

		int cnt = ps.executeUpdate();

		ps.close();

		return cnt;

	}

	// 원하는 달의 전체내역 보여주기
	public ArrayList<MoneyBookVO> monthAccountList(Connection conn, MoneyBookVO book) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT   							");
		query.append("	     use_date					");
		query.append("	   , mem_id						");
		query.append("	   , gubun						");
		query.append("	   , money_category				");
		query.append("	   , account					");
		query.append("	   , payment_category			");
		query.append("	   , contents					");
		query.append("FROM   							");
		query.append("		 moneybook					");
		query.append("WHERE 1=1							");
		query.append("	AND mem_id = ?					");
		query.append("	AND substr(use_date,1,2) = ?	");
		query.append("	AND substr(use_date,4,2) = ?	");
		query.append("ORDER BY use_date					");

		PreparedStatement ps = conn.prepareStatement(query.toString());
		int idx = 1;
		ps.setString(idx++, book.getMem_id());
		ps.setString(idx++, book.getUse_date().substring(0, 2));
		ps.setString(idx++, book.getUse_date().substring(3, 5));

		ResultSet rs = ps.executeQuery();

		ArrayList<MoneyBookVO> result = new ArrayList<>();

		while (rs.next()) {
			String use_date = rs.getString("use_date");
			String mem_id = rs.getString("mem_id");
			String gubun = rs.getString("gubun");
			String money_category = rs.getString("money_category");
			int account = rs.getInt("account");
			String payment_category = rs.getString("payment_category");
			String contents = rs.getString("contents");

			MoneyBookVO money = new MoneyBookVO();
			money.setUse_date(use_date);
			money.setMem_id(mem_id);
			money.setGubun(gubun);
			money.setMoney_category(money_category);
			money.setAccount(account);
			money.setPayment_category(payment_category);
			money.setContents(contents);

			result.add(money);
		}
		rs.close();
		ps.close();

		return result;
	}

	// 항목별 전체내역 보여주기
	public ArrayList<MoneyBookVO> moneyAccountList(Connection conn, MoneyBookVO book) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT   							");
		query.append("	     use_date					");
		query.append("	   , mem_id						");
		query.append("	   , gubun						");
		query.append("	   , money_category				");
		query.append("	   , account					");
		query.append("	   , payment_category			");
		query.append("	   , contents					");
		query.append("FROM   							");
		query.append("		 moneybook					");
		query.append("WHERE 1=1							");
		query.append("	AND mem_id = ?					");
		query.append("	AND money_category = ?			");
		query.append("ORDER BY use_date					");

		PreparedStatement ps = conn.prepareStatement(query.toString());
		int idx = 1;
		ps.setString(idx++, book.getMem_id());
		ps.setString(idx++, book.getMoney_category());

		ResultSet rs = ps.executeQuery();

		ArrayList<MoneyBookVO> result = new ArrayList<>();

		while (rs.next()) {
			String use_date = rs.getString("use_date");
			String mem_id = rs.getString("mem_id");
			String gubun = rs.getString("gubun");
			String money_category = rs.getString("money_category");
			int account = rs.getInt("account");
			String payment_category = rs.getString("payment_category");
			String contents = rs.getString("contents");

			MoneyBookVO money = new MoneyBookVO();
			money.setUse_date(use_date);
			money.setMem_id(mem_id);
			money.setGubun(gubun);
			money.setMoney_category(money_category);
			money.setAccount(account);
			money.setPayment_category(payment_category);
			money.setContents(contents);

			result.add(money);
		}
		rs.close();
		ps.close();

		return result;
	}

	// 결제구분별 전체내역 보여주기
	public ArrayList<MoneyBookVO> paymentAccountList(Connection conn, MoneyBookVO book) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT   							");
		query.append("	     use_date					");
		query.append("	   , mem_id						");
		query.append("	   , gubun						");
		query.append("	   , money_category				");
		query.append("	   , account					");
		query.append("	   , payment_category			");
		query.append("	   , contents					");
		query.append("FROM   							");
		query.append("		 moneybook					");
		query.append("WHERE 1=1							");
		query.append("	AND mem_id = ?					");
		query.append("	AND payment_category = ?		");
		query.append("ORDER BY use_date					");

		PreparedStatement ps = conn.prepareStatement(query.toString());
		int idx = 1;
		ps.setString(idx++, book.getMem_id());
		ps.setString(idx++, book.getPayment_category());

		ResultSet rs = ps.executeQuery();

		ArrayList<MoneyBookVO> result = new ArrayList<>();

		while (rs.next()) {
			String use_date = rs.getString("use_date");
			String mem_id = rs.getString("mem_id");
			String gubun = rs.getString("gubun");
			String money_category = rs.getString("money_category");
			int account = rs.getInt("account");
			String payment_category = rs.getString("payment_category");
			String contents = rs.getString("contents");

			MoneyBookVO money = new MoneyBookVO();
			money.setUse_date(use_date);
			money.setMem_id(mem_id);
			money.setGubun(gubun);
			money.setMoney_category(money_category);
			money.setAccount(account);
			money.setPayment_category(payment_category);
			money.setContents(contents);

			result.add(money);
		}
		rs.close();
		ps.close();

		return result;
	}
}
