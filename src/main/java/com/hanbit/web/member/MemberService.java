/**
 * 
 */
package com.hanbit.web.member;

import java.util.List;

import com.hanbit.web.subject.SubjectMember;
import com.hanbit.web.util.CommonService;




/**
 * @date : 2016. 6. 17.
 * @author : hb2009
 * @file : StudentService.java
 * @story :
 */
public interface MemberService extends CommonService {
	public String regist(MemberBean bean);

	public MemberBean show();

	public void update(MemberBean mem);

	public void delete(MemberBean mem);

	public int count();

	public MemberBean findById(String findId);

	public List<MemberBean> list();

	public List<MemberBean> findByName(String findName);

	public SubjectMember login(MemberBean member);

	public int genderCount(String gender);	
	
	public void logout(MemberBean member);
	
}
// String sqlCreate = "create table member("
// + "id varchar2(20) primary key,"
// + "name varchar2(20),"
// + "ssn varchar2(20),"
// + "pw varchar2(20),"
// + "reg_date varchar2(20)"
// + "),";