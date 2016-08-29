/**
 * 
 */
package com.hanbit.web.member;

import java.util.List;

import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.util.CommonService;




/**
 * @date : 2016. 6. 17.
 * @author : hb2009
 * @file : StudentService.java
 * @story :
 */
public interface MemberService extends CommonService {
	public String regist(MemberVO bean);

	public MemberVO show();

	public void update(MemberVO mem);

	public void delete(MemberVO mem);

	public int count();

	public MemberVO findById(String findId);

	public List<MemberVO> list();

	public List<MemberVO> findByName(String findName);

	public SubjectMemberVO login(MemberVO member);

	public int genderCount(String gender);	
	
	public void logout(MemberVO member);
	
}
// String sqlCreate = "create table member("
// + "id varchar2(20) primary key,"
// + "name varchar2(20),"
// + "ssn varchar2(20),"
// + "pw varchar2(20),"
// + "reg_date varchar2(20)"
// + "),";