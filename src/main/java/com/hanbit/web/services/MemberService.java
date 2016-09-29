/**
 * 
 */
package com.hanbit.web.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;




/**
 * @date : 2016. 6. 17.
 * @author : hb2009
 * @file : StudentService.java
 * @story :
 */
@Component
public interface MemberService {
	public String regist(MemberDTO bean);
	public MemberDTO findOne(Command command);
	public MemberDTO show();
	public String update(MemberDTO mem);
	public String delete(String id);
	public List<?> find(Command command);
	public Retval count();
	public List<MemberDTO> findByName(String findName);
	public int genderCount(String gender);	
	public void logout(MemberDTO member);
	public MemberDTO login(MemberDTO member);
	public int existId(String id);
	public List<?> list(Command command);
	
}
