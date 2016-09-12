package com.hanbit.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @date : 2016. 6. 30.
 * @author : 신재현
 * @file : JDBCTest.java
 * @story :
 * null와 new의 차이
 * new는 건물을 짓는것이고 null은 땅만 골라 놓는것
 * 필요한 값만 불러올때는 땅만 골라놓는 것이 낭비가 없다
 * 어떻게 하면 빠르게 할까에 대한 고민이 필요하당!!
 */

public class JDBCTest { //연결을 확인하는 작업
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select name,ssn from member where mem_id = 'lee'", result = "";// 안에 무슨 테이블이 있냐??
		List<String> list = new ArrayList<String>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL, 
					Constants.USER_ID, 
					Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				
				result = rs.getString(1);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);

	}
}
