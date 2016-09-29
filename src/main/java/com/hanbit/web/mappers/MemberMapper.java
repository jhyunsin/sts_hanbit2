package com.hanbit.web.mappers;

import java.util.List;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;


public interface MemberMapper {
	public int insert(MemberDTO member);
	public int delete(String id);
	public int update(MemberDTO member);
	public List<?> list(Command command);
	public MemberDTO findOne(Command command);
	public List<MemberDTO> findByname(String name);
	public Retval count();
	public boolean login(MemberDTO param);
	public int existId(String id);
	public int findId(String id);
	public int genderCount(String gender);
	public List<?> find(Command command);
	 
		
	
}
