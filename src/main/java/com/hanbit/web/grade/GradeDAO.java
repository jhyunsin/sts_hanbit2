package com.hanbit.web.grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;


/**
 * @date : 2016. 7. 4.
 * @author : 신재현
 * @file : GradeDAO.java
 * @story :
 */

public class GradeDAO {/// 싱글톤은 DAO부터

	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	private static GradeDAO instance = new GradeDAO();

	public static GradeDAO getInstance() {
		return instance;
	}

	private GradeDAO() {
		con = DatabaseFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}

	
	
//	public int exeUpdate(String sql) {
//		int result = 0;
//
//		try {
//			Class.forName(Constants.ORACLE_DRIVER);
//			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
//			stmt = con.createStatement();
//			result = stmt.executeUpdate(sql);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		if (result == 1) {
//			System.out.println("성공");
//		} else {
//			System.out.println("실패");
//		}
//		return result;
//
//	}

	
	
	public int insert(GradeBean bean) {
		int result = 0;
		String sql = "insert into grade(seq,grade,java,sql,html,javascript,id,exam_date)values(seq.nextval,?,?,?,?,?,?,?)";
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getGrade());
			pstmt.setInt(2, bean.getJava());
			pstmt.setInt(3, bean.getSql());
			pstmt.setInt(4, bean.getHtml());
			pstmt.setInt(5, bean.getJavascript());
			pstmt.setString(6, bean.getId());
			pstmt.setString(7, bean.getExamDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int update(GradeBean bean) {
	int result = 0;
	String sql = "";
	
		return result;
	}

	public int delete(int seq) {
		// 삭제
		int result = 0;
		String sql = "delete from grade where seq = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, seq);
		rs = pstmt.executeQuery();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public List<GradeBean> list() {

		List<GradeBean> list = new ArrayList<GradeBean>();
		String sql = "select * from grade";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GradeBean g = new GradeBean();
				g.setSeq(rs.getString("SEQ"));
				g.setGrade(rs.getString("GRADE"));
				g.setJava(rs.getInt("JAVA"));
				g.setSql(rs.getInt("SQL"));
				g.setHtml(rs.getInt("HTML"));
				g.setJavascript(rs.getInt("JAVASCRIPT"));
				g.setId(rs.getString("ID"));
				g.setExamDate(rs.getString("EXAM_DATE"));
				list.add(g);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public List<GradeBean> findById(String id) {
		// TODO Auto-generated method stub

		String sql = "select * from grade where id=?";
		List<GradeBean> list = new ArrayList<GradeBean>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
//			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				GradeBean t = new GradeBean(
						rs.getString("SEQ"), 
						rs.getString("GRADE"), 
						rs.getInt("JAVA"),
						rs.getInt("SQL"), 
						rs.getInt("HTML"), 
						rs.getInt("JAVASCRIPT"), 
						rs.getString("ID"),
						rs.getString("EXAM_DATE"));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}


	public int count(String examDate) {
		int result = 0;
		String sql = "select count(*) as count from grade where exam_date = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, examDate);
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

	public GradeBean findBySeq(String seq) {
		// TODO Auto-generated method stub
		GradeBean s =  new GradeBean(); 
		String sql = "select * from grade where seq = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(seq));
			rs = pstmt.executeQuery();
		 if (rs.next()) {
			
//			 rs.getString("SEQ"),  생성자 쓰고 안쓰고의 차이
//				rs.getString("GRADE"),
//				rs.getInt("JAVA"),
//				rs.getInt("SQL"),
//				rs.getInt("HTML"),
//				rs.getInt("JAVASCRIPT"),
//				rs.getString("ID"),
//				rs.getString("EXAM_DATE"));
			
			 s.setSeq(rs.getString("SEQ"));
			 s.setGrade(rs.getString("GRADE"));
			 s.setJava(rs.getInt("JAVA"));
			 s.setSql(rs.getInt("SQL"));
			 s.setHtml(rs.getInt("HTML"));
			 s.setJavascript(rs.getInt("JAVASCRIPT"));
			 s.setId(rs.getString("ID"));
			 s.setExamDate(rs.getString("EXAM_DATE"));
		 
		 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}

}
/*
String sql = "select * from grade where sql = " + seq + "";
		GradeBean bean = null;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				bean = new GradeBean(rs.getString("SEQ"), rs.getString("GRADE"), rs.getInt("JAVA"), rs.getInt("SQL"),
						rs.getInt("HTML"), rs.getInt("JAVASCRIPT"), rs.getString("ID"), rs.getString("EXAM_DATE"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 * */
