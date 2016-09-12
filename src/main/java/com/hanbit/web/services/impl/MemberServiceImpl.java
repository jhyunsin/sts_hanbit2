package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hanbit.web.controllers.AdminController;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;




@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired private MemberDTO member; /// getInstance 가 아닌 new 로 만드는 것들은 모드 Autowired 로 처리한다 이것이 문법이다
	@Autowired private SubjectDTO sb;
	@Qualifier private MemberMapper memberMapper;
	
	@Override
	public String regist(MemberDTO bean) {
		// 1등록
		String msg = "";
		MemberDTO temp = this.findById(bean.getId());
		if (temp==null) {
			System.out.println(bean.getId()+ "가 존재하지 않음,가입가능한 ID");
			int result = 0;
			if (result == 1) {
			msg = "success";
			 } else {
			msg = "fail";
	      	}
		}else{
			System.out.println(bean.getId()+ "가 존재함 ,가입 불가한 ID");
			msg = "fail";
		}
		return msg;
	}

	@Override
	public MemberDTO show() {
		// 2보기
		memberMapper.count();
		return member;
	}

	@Override
	public void update(MemberDTO mem) {
		// 3수정
		int result = 0;
		if (result ==1) {
			member = this.findById(mem.getId());
		System.out.println("업데이트결과 성공");
		}else{
			System.out.println("업데이트결과 실패");
		}
	
	
	}

	@Override
	public void delete(MemberDTO mem) {
		// 4삭제
		String result = "";
	
		
		}

	@Override
	public int count() {
		// 컨트롤러에서 int count = service.count(); 만들고 서비스 / 임플 까지 타고 타고옴
		return 0;//토스
	}

	@Override
	public MemberDTO findById(String findID) {
	
		return null;
	}

	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> findByName(String findName) {
		// TODO Auto-generated method stub
		return null;
	}
		
	

	@Override
	public int genderCount(String gender) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void logout(MemberDTO member) {
		
		if (member.getId().equals(member.getId()) && 
				member.getPw().equals(member.getPw())) {
			member = null;
		}
		
	}

	@Override
	public List<?> findBy(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}


