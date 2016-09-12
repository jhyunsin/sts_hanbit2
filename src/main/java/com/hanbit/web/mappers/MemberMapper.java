package com.hanbit.web.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.MemberDTO;

@Repository
public interface MemberMapper {
	public int insert(MemberDTO member);
	public int delete(MemberDTO member);
	public int update(MemberDTO member);
	public List<MemberDTO> list();
	public MemberDTO findById(String id);
	public List<MemberDTO> findByname(String name);
	public int count();
	public boolean login(MemberDTO param);
	public boolean existId(String id);
	public int findId(String id);
	public int genderCount(String gender);
}
