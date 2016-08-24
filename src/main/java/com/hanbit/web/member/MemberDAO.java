package com.hanbit.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.util.Constants;


/**
 * @date : 2016. 7. 1.
 * @author : 신재현
 * @file : MemberDAO.java
 * @story :
 */

public class MemberDAO {
//
//	"1회원가입2로그인3내정보수정보기4(비번)수정5탈퇴 0종료\n"
//			+ "------관리자가보는화면------\n" + 
//"11회원목록12검색(ID)13검색(이름)14 검색(성별)15회원수"))
	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null; // 7.4 오늘 하나 추가
	// pstmt 와 stmt의 차이~!!
	
	ResultSet rs = null; // executeQuery()에서만 리턴받는객체
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAO() {
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
////////////////////////////////////////////////////////////////
	
	public int insert(MemberBean mem){//회원가입
		int result = 0;
		String sql = "insert into member(id,pw,name,reg_date,ssn,email,profile_img,phone)"+"values(?,?,?,?,?,?,?,?)";
		
		try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, mem.getId());
		pstmt.setString(2, mem.getPw());
		pstmt.setString(3, mem.getName());
		pstmt.setString(4, mem.getRegDate());
		pstmt.setString(5, mem.getSsn());
		pstmt.setString(6, mem.getEmail());
		pstmt.setString(7, "default.jpg");
		pstmt.setString(8, mem.getPhone());
		
		result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 1) {
			System.out.println("DAO 가입성공");
		} else {
			System.out.println("DAO 가입실패");
		}
		return result;
	}
	
	public int delete(MemberBean mem){//탈퇴
	int result = 0;
		String sql = "delete from member where id = ? and pw=?";	
	
		try {
			pstmt = con.prepareStatement(sql);
		pstmt.setString(1, mem.getId());
		pstmt.setString(2, mem.getPw());
		result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 1) {
			System.out.println("DAO 삭제성공");
		} else {
			System.out.println("DAO 삭제실패");
		}
		return result; 
	}
	
	public int update(MemberBean mem) {
		int result =0;
		String sql = "update member set pw= ? , email = ? where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getPw());
			pstmt.setString(2, mem.getEmail());
			pstmt.setString(3, mem.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 1) {
			System.out.println("DAO 수정성공");
		} else {
			System.out.println("DAO 수정실패");
		}
		return result;
	}

	public int exeUpdate(String sql) {
		int result = 0;

		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		return result;

	}
	//list
	public List<MemberBean> list() {
		String sql ="select * from member";
		List<MemberBean> list = new ArrayList<MemberBean>();
			try {
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
				MemberBean t = new MemberBean();
				t.setId(rs.getString("ID"));
				t.setPw(rs.getString("PW"));
				t.setName(rs.getString("NAME"));
				t.setEmail(rs.getString("EMAIL"));
				t.setGenderAndBirth(rs.getString("SSN"));
				t.setRegDate(rs.getString("REG_DATE"));
				t.setProImg(rs.getString("PROFILE_IMG"));
				list.add(t);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(list.get(3));
		return list;
	}
	
	
	
	//findbyPK
	public MemberBean findById(String pk) {
		String sql = "select * from member where id=?";
		MemberBean temp = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pk);
			rs = pstmt.executeQuery();
			if (rs.next()) {
			temp = new MemberBean();
			temp.setId(rs.getString("ID"));	 
			temp.setPw(rs.getString("PW"));	 
			temp.setName(rs.getString("NAME"));	
			temp.setEmail(rs.getString("EMAIL"));
			temp.setGenderAndBirth(rs.getString("SSN"));;
			temp.setRegDate(rs.getString("REG_DATE"));
			temp.setProImg(rs.getString("PROFILE_IMG"));
			temp.setPhone(rs.getString("PHONE"));
			System.out.println("DAO에서 아이디존재 체크"+temp.getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	// findbynNotPK
	public List<MemberBean> findByname(String name) {
		String sql = "select * from member where name=?";
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {//동명이 있을수 있으니 if 가 아닌 와일
				MemberBean temp = new MemberBean();
				temp.setId(rs.getString("ID"));	 
				temp.setPw(rs.getString("PW"));	 
				temp.setName(rs.getString("NAME"));	
				temp.setEmail(rs.getString("EMAIL"));
				temp.setGenderAndBirth(rs.getString("SSN"));;
				temp.setRegDate(rs.getString("REG_DATE"));
				temp.setProImg(rs.getString("PROFILE_IMG"));
				temp.setPhone(rs.getString("PHONE"));
				System.out.println("DAO에서 아이디존재 체크"+temp.getId());
				list.add(temp);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	//count
		public int count() {
		// 임플에서 return dao.count(); 만들고 에러잡기형식
	String sql = "select count(*) as count from member";
	int count = 0;		
	try {
			Class.forName(Constants.ORACLE_DRIVER);
	con = 	DriverManager.getConnection(
				Constants.ORACLE_URL,
				Constants.USER_ID,
				Constants.USER_PW);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			count = rs.getInt("count");
		} ///뒤가 있냐 없냐의 블린타입 조건안이 참일떄까지 돈다
			//값이 하나밖에 없다는것때문에 0을 준다
		
			
		
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			return count;
	}

		public boolean login(MemberBean param) {
			// TODO Auto-generated method stub
			boolean loginOk = false;
			if (param.getId()!=null
					&& param.getPw()!=null 
					&& this.existId(param.getId())) {
				MemberBean member = this.findById(param.getId());
				if (member.getPw().equals(param.getPw())) {//멤버에서 넘어온 비번과 지금 비번이 같다면...
				loginOk = true;
				}
			}
			return loginOk;
		}
		
		public boolean existId(String id){
			boolean existOK = false;
			int result = 0;
			String sql = "select count(*) as count from member where id = ? ";
         try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
        	 rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
				System.out.println("ID카운트결과"+result);
			}
         } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result==1) {
			existOK = true;
		}	
         
         return existOK;
		}

		public int findId(String id) {
			// 아이디찾기 for 성별수
			int result = 0;
			String sql = "select count(*) count from member where id = ?";
			
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

		public int genderCount(String gender) {
			// 성별 회원수
		int	result = 0;
		String sql = "select count(*) count form member where";
			
			return result;
		}
}
