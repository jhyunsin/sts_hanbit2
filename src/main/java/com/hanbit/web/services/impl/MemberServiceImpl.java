package com.hanbit.web.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hanbit.web.controllers.AdminController;
import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;




@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired private SqlSession sqlSession;
	@Autowired private Command command;
	@Qualifier private MemberDTO member; /// getInstance 가 아닌 new 로 만드는 것들은 모드 Autowired 로 처리한다 이것이 문법이다
	@Autowired private SubjectDTO sb;
	@Qualifier private MemberMapper memberMapper;
	
	
	@Override
	public String regist(MemberDTO member) {
		// 1등록
		System.out.println("id : "+member.getId());
		System.out.println("pw : "+member.getPw());
		System.out.println("Name : "+member.getName());
		System.out.println("남여 : "+member.getGender());
		System.out.println("등록일 : "+member.getRegDate());
		System.out.println("ssn : "+member.getSsn());
		System.out.println("email : "+member.getEmail());
		System.out.println("PROFILE_IMG : "+member.getProfileImg());
		System.out.println("phone : "+member.getPhone());
		return (sqlSession.getMapper(MemberMapper.class).insert(member)!=0)?"success":"fail";
	}
		
	@Override
	public MemberDTO show() {
		// 2보기
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.count();
		return member;
	}

	@Override
	public String update(MemberDTO mem) {
		// 3수정
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = 0;
		String retval = "";
		if (mapper.update(mem)!=0) {
			retval = "success";
		
		}else{
			retval = "fail";
		}
		return retval;
	
	
	}

	@Override
	public String delete(String id) {
		// 4삭제
		return (sqlSession.getMapper(MemberMapper.class).delete(id)==1)?"success":"fail";
		
		}



	@Override
	public MemberDTO findOne(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findOne(command);
	}



	@Override
	public List<MemberDTO> findByName(String findName) {
		// TODO Auto-generated method stub
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}
		
	

	@Override
	public int genderCount(String gender) {
		// TODO Auto-generated method stub
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return 0;
	}

	@Override
	public void logout(MemberDTO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		if (member.getId().equals(member.getId()) && 
				member.getPw().equals(member.getPw())) {
			member = null;
		}
		
	}

//	@Override
//	public List<?> findBy(String keyword) {
//		// TODO Auto-generated method stub
//		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//		return null;
//	}

//	@Override
//	public Map<?, ?> map() {
//		// TODO Auto-generated method stub
//		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//		return null;
//	}

	@Override
	public MemberDTO login(MemberDTO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		command.setKeyword(member.getId());
		command.setOption("mem_id");
		MemberDTO mem = mapper.findOne(command);
		logger.info("MemberService PASSWORD IS : {}",mem.getPw());
		if (mem.getPw().equals(member.getPw())) {
			logger.info("MemberService login IS : {}","SUCCESS");
			logger.info("MemberService login ID == {}",mem.toString());
			return mem;
		}else{
		mem.setId("NONE");
		logger.info("MemberService login IS : {}","FAIL");
		return mem;
		}
		}

	@Override
	public int existId(String id) {
		logger.info("MemberService exitId ID IS : {}",id);
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.existId(id);
	}


	public List<?> list(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.list(command);
	}

	@Override
	public Retval count() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.count();
	}

	@Override
	public List<?> find(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.find(command);
	}



	
	
	}


