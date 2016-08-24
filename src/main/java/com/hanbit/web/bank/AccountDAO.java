package com.hanbit.web.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;



/**
 * @date   : 2016. 7. 6.
 * @author : 신재현
 * @file   : AccountDAO.java
 * @story   :
 */

public class AccountDAO {

	private static AccountDAO instance = new AccountDAO();
	private	Connection con;
	private	ResultSet rs;
	private	PreparedStatement pstmt;
	private AccountDAO() {
				con = DatabaseFactory.createDatabase(Vendor.ORACLE, 
					Constants.USER_ID, 
					Constants.USER_PW).getConnection();
		}
	public static AccountDAO getInstance() {
	return instance;
}
	
	public int insertAccount(AccountBean acc) {
		// 계좌개설
		int result = 0;
		String sql = "insert into account (id, account_no, money) "
				+ "values(?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setInt(2, acc.getAccountNo());
			pstmt.setInt(3, acc.getMoney());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int getRestMoney(int accountNo) {
		String sql = "select money from account where account_no = ?";
		int money = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				money = rs.getInt("MONEY");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
	}
	
	public void deposit(AccountBean bean) {
		// 입급
		
		String sql = "update account set money=? where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getMoney());
			pstmt.setInt(2, bean.getAccountNo());
			 pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void withdraw(AccountBean acc) {
		// 출금
		this.deposit(acc);
		}

	
	public int selectMoney(int accNo) {
		int money = 0;
		String sql = "select money from account where account_no=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				money = rs.getInt("MONEY");
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return money;
	}
	public int deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "delete from account where account_no=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int count() {
		// 전체통장수
		int result = 0;
		String sql = "select count(*) as count from account_member";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		if (rs.next()) {
			result = rs.getInt("count");
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	public List<?> selectAll() {
		// 전체조회
		List<AccountMemberBean> list = new ArrayList<AccountMemberBean>();
		String sql = "select "
				+ "account_no as acc,"
				+ "id as id,"
				+ "money as money,"
				+ "name as name,"
				+ "ssn as birth"//// 컬럼값 변경 뷰에서만 통용
				+ " from  account_member"// 스페이스 주는거
				+ " order by name";/// 정렬
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AccountMemberBean acc = new AccountMemberBean();
				acc.setAccountNo(rs.getInt("ACC"));
				acc.setId(rs.getString("ID"));
				acc.setMoney(rs.getInt("MONEY"));
				acc.setName(rs.getString("NAME"));
				acc.setBirth(rs.getString("BIRTH").substring(0, 6));///스플릿 친 효과 0~6미만의 인덱스를 뽑아낸다
				list.add(acc);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Map<?, ?> selectMap() {
		Map<String, AccountMemberBean> map = new HashMap<String,AccountMemberBean>();
		String sql = "select * from account_member";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AccountMemberBean am = new AccountMemberBean();
				am.setAccountNo(rs.getInt("ACCOUNT_NO"));
				am.setId(rs.getString("ID"));
				am.setMoney(rs.getInt("MONEY"));
				am.setName(rs.getString("NAME"));
				am.setSsn(rs.getString("SSN"));
				am.setRegDate(rs.getString("REG_DATE"));
				am.setPw(String.valueOf(rs.getInt("PW")));
				map.put(String.valueOf(am.getAccountNo()), am);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return map;
	}
	public int updageAccount(AccountBean acc) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
