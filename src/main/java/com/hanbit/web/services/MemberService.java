/**
 * 
 */
package com.hanbit.web.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.util.CommonService;




/**
 * @date : 2016. 6. 17.
 * @author : hb2009
 * @file : StudentService.java
 * @story :
 */
@Component
public interface MemberService extends CommonService {
	public String regist(MemberDTO bean);
	public MemberDTO findOne(Command command);

	public MemberDTO show();

	public void update(MemberDTO mem);

	public void delete(MemberDTO mem);

	public int count();


	public List<MemberDTO> list();

	public List<MemberDTO> findByName(String findName);

	public int genderCount(String gender);	
	
	public void logout(MemberDTO member);
	
	public MemberDTO login(MemberDTO member);
	public int existId(String id);
}
// String sqlCreate = "create table member("
// + "id varchar2(20) primary key,"
// + "name varchar2(20),"
// + "ssn varchar2(20),"
// + "pw varchar2(20),"
// + "reg_date varchar2(20)"
// + "),";