package com.hanbit.web.bank;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;



/**
 * @date   : 2016. 7. 6.
 * @author : 신재현
 * @file   : AccountDAO.java
 * @story   :
 */
@Repository
public class AccountDAOImpl implements AccountDAO{
	private static final String NAMESPACE = "mapper.account.";
	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
	private static AccountDAOImpl instance = new AccountDAOImpl();
	private SqlSessionFactory sqlSessionFactory = null;
	public AccountDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	private AccountDAOImpl() {
		try {
			InputStream	is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("session build fail");
		}
		}
	public static AccountDAOImpl getInstance() {
		if (instance == null) {
			logger.info("AccountDAOImpl instance is created");
		}
		return instance;
}
	@Override
	public int insertAccount(AccountVO acc) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.insert(NAMESPACE + "insertAccount", acc);
		} finally {
			session.close();
		}
	
	}
	@Override
	public void deposit(AccountVO bean) {
		this.deposit(bean);
	}
	@Override
	public void withdraw(AccountVO acc) {
		// 출금
		this.deposit(acc);
		}

	@Override
	public int selectMoney(int accNo) {
		SqlSession session = sqlSessionFactory.openSession();
			try {
			return session.selectOne(NAMESPACE + "insertAccount", accNo);
		} finally {
			session.close();
		}
	}
	@Override
	public int deleteAccount(int accountNo) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
		return session.selectOne(NAMESPACE + "deleteAccount", accountNo);
	} finally {
		session.close();
	}
	}
	@Override
	public int count() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
		return session.selectOne(NAMESPACE + "count");
	} finally {
		session.close();
	}
	}
	@Override
	public List<?> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
		return session.selectList(NAMESPACE + "count");
	} finally {
		session.close();
	}
	}
	@Override
	public Map<?, ?> selectMap() {
		Map<String, AccountMemberVO> map = new HashMap<String,AccountMemberVO>();
		String sql = "select * from account_member";
		
//		try {
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				AccountMemberVO am = new AccountMemberVO();
//				am.setAccountNo(rs.getInt("ACCOUNT_NO"));
//				am.setId(rs.getString("ID"));
//				am.setMoney(rs.getInt("MONEY"));
//				am.setName(rs.getString("NAME"));
//				am.setSsn(rs.getString("SSN"));
//				am.setRegDate(rs.getString("REG_DATE"));
//				am.setPw(String.valueOf(rs.getInt("PW")));
//				map.put(String.valueOf(am.getAccountNo()), am);
//				
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		return map;
	}
	@Override
	public int updageAccount(AccountVO acc) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getRestMoney(int accountNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
