package com.hanbit.web.member;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.hanbit.web.util.Constants;


/**
 * @date : 2016. 7. 1.
 * @author : 신재현
 * @file : MemberDAO.java
 * @story :
 */
//
//"1회원가입2로그인3내정보수정보기4(비번)수정5탈퇴 0종료\n"
//		+ "------관리자가보는화면------\n" + 
//"11회원목록12검색(ID)13검색(이름)14 검색(성별)15회원수"))
@Repository
public class MemberDAOImpl implements MemberDAO{
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	private static final String NAMESPACE = "mapper.member.";
	private static MemberDAOImpl instance = new MemberDAOImpl();
	
	public static MemberDAOImpl getInstance() {
		if (instance == null) {
			logger.info("MemberDAOImpl instance is created");
		}
		return instance;
	}
	private MemberDAOImpl() {
		try {
			InputStream	is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("session build fail");
		}
	}
	
	
	private SqlSessionFactory sqlSessionFactory = null;
	public MemberDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public int insert(MemberVO member){//회원가입
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",member);
	}
	
	@Override
	public int delete(MemberVO member){//탈퇴
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",member);
	}
	@Override
	public int update(MemberVO member) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",member);
	}
	
	//list
	@Override
	public List<MemberVO> list() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	
	
	
	//findbyPK
	@Override
	public MemberVO findById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("findById 진입");
		try {
			return session.selectOne(NAMESPACE + "findById", id);
		} finally {
			session.close();
		}
		
 //		MemberVO temp1 = new MemberVO();//		try{//			 temp1 = session.selectOne(NAMESPACE+"findById",id);//			//		}finally{//			session.close();//				}//		if (temp1 == null) {//			System.out.println("findbyid  실패");//		}//		//		logger.info("MemberDAOImpl instance is created");//		return temp1;
		
	}

	
	@Override
	public List<MemberVO> findByname(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("",name);
	}
	
	
	@Override	
	public int count() {
		
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("");
	}
	@Override
		public boolean login(MemberVO param) {
			// TODO Auto-generated method stub
			boolean loginOk = false;
			if (param.getId()!=null
					&& param.getPw()!=null && this.existId(param.getId())
					) {
				MemberVO member = this.findById(param.getId());
				if (member.getPw().equals(param.getPw())) {//멤버에서 넘어온 비번과 지금 비번이 같다면...
				loginOk = true;
				}
			}
			return loginOk;
		}
	@Override
		public boolean existId(String id){
		boolean flag = false;
		SqlSession session = sqlSessionFactory.openSession();
		try{
			int temp = session.selectOne(NAMESPACE + "existId",id);
		if (temp==1) {flag = true;} 
		}
		finally{
		session.close();	
		}
		return flag;
		
				
		
		}
	@Override
		public int findId(String id) {
			// 아이디찾기 for 성별수
			int result = 0;
//			String sql = "select count(*) count from member where id = ?";
//			
//			try {
//				pstmt = con.prepareStatement(sql);
//				rs = pstmt.executeQuery();
//			if (rs.next()) {
//				result = rs.getInt("count");
//			}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
			return result;
		}
	@Override
		public int genderCount(String gender) {
			// 성별 회원수
		int	result = 0;
		String sql = "select count(*) count form member where";
			
			return result;
		}
}
