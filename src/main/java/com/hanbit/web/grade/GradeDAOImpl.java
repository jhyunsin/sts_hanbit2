package com.hanbit.web.grade;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;


/**
 * @date : 2016. 7. 4.
 * @author : 신재현
 * @file : GradeDAO.java
 * @story :
 */
@Repository
public class GradeDAOImpl implements GradeDAO{/// 싱글톤은 DAO부터

	private SqlSessionFactory sqlSessionFactory = null;
	public GradeDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	private static final String NAMESPACE = "mapper.grade.";
	private static GradeDAOImpl instance = new GradeDAOImpl();

	public static GradeDAOImpl getInstance() {
		if (instance == null) {
			logger.info("MemberDAOImpl instance is created");
		}
		return instance;
	}

	private GradeDAOImpl() {
		try {
			InputStream	is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("session build fail");
		}
	}



	public int insert(GradeVO bean) {
		SqlSession session = sqlSessionFactory.openSession();
	
		try {
			return session.insert(NAMESPACE + "insert", bean);
		} finally {
			session.close();
		}
	}

	public int update(GradeVO bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.update(NAMESPACE + "update", bean);
		} finally {
			session.close();
		}
	}

	public int delete(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.delete(NAMESPACE + "delete", seq);
		} finally {
			session.close();
		}
	}

	public List<GradeVO> list() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList(NAMESPACE + "list");
		} finally {
			session.close();
		}
	}

	public GradeVO findById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "findById", id);
		} finally {
			session.close();
		}

	}


	public int count(String examDate) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "count", examDate);
		} finally {
			session.close();
		}
	}
	@Override
	public GradeVO findBySeq(String seq) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "findBySeq", seq);
		} finally {
			session.close();
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
}