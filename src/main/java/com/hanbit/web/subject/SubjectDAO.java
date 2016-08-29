package com.hanbit.web.subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hanbit.web.util.Constants;


/**
 * @date   : 2016. 7. 26.
 * @author : 신재현
 * @file   : SubjectDAO.java
 * @story   :
 */

public class SubjectDAO {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static SubjectDAO instance = new SubjectDAO();  
	
	public static SubjectDAO getInstance() {
	return instance;
}

	private SubjectDAO() {
	try {
		Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL, 
					Constants.USER_ID, 
					Constants.USER_PW);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

public void insert(SubjectVO sub){
	int result=0;
	String sql = "insert into subject(subj_seq,id,major,subjects) values (subj_seq.nextval,?,?,? )";

	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sub.getId());
		pstmt.setString(2, sub.getMajor());
		pstmt.setString(3, sub.getSubjects());
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	if (result==1) {
		System.out.println("과목추가성공");
	}else{
		System.out.println("과목추가실패");
		
	}
}

public SubjectVO findById(String id){
	SubjectVO s = null;
	String sql = "select id as id, major as major, subjects as sub from subject where id = ?";
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			s = new SubjectVO();
			s.setId(rs.getString("id"));
			s.setId(rs.getString("major"));
			s.setId(rs.getString("sub"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return s;
}

}
