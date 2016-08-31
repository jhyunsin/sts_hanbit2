package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImpl;
import com.hanbit.web.subject.SubjectVO;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectMemberVO;




@Service
public class MemberServiceImpl implements MemberService {
	
	
	private MemberDAOImpl dao; 
	private SubjectDAOImpl subjDao;
	@Autowired private MemberVO member; /// getInstance 가 아닌 new 로 만드는 것들은 모드 Autowired 로 처리한다 이것이 문법이다
	@Autowired private SubjectVO sb;
	@Autowired private SubjectMemberVO sm;
	@Autowired private AccountServiceImpl accService;
	
	
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
		subjDao = SubjectDAOImpl.getInstance();
	}

	@Override
	public String regist(MemberVO bean) {
		// 1등록
		String msg = "";
		MemberVO temp = this.findById(bean.getId());
		if (temp==null) {
			System.out.println(bean.getId()+ "가 존재하지 않음,가입가능한 ID");
			int result = dao.insert(bean);
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
	public MemberVO show() {
		// 2보기
		return member;
	}

	@Override
	public void update(MemberVO mem) {
		// 3수정
		int result = dao.update(mem);
		if (result ==1) {
			member = this.findById(mem.getId());
		System.out.println("업데이트결과 성공");
		}else{
			System.out.println("업데이트결과 실패");
		}
	
	
	}

	@Override
	public void delete(MemberVO mem) {
		// 4삭제
		String result = "";
		if (dao.delete(mem) ==1) {
			result = "삭제성공";
			member = null;
		} else {
			result = "삭제실패";
		}	
		
		}

	@Override
	public int count() {
		// 컨트롤러에서 int count = service.count(); 만들고 서비스 / 임플 까지 타고 타고옴
		return dao.count();//토스
	}

	@Override
	public MemberVO findById(String findID) {
	
		return dao.findById(findID);
	}

	@Override
	public List<MemberVO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public List<MemberVO> findByName(String findName) {
		// TODO Auto-generated method stub
		return dao.findByname(findName);
	}
		
	public SubjectMemberVO login(MemberVO member) {
		//로그인
		SubjectMemberVO sm = new SubjectMemberVO();
		SubjectVO sb = new SubjectVO();
		if (dao.login(member)) {
			member = dao.findById(member.getId());
			System.out.println("서비스로그인 하는 중..ID :" +member.getId());
//			accService.map();
			sb = subjDao.findById(member.getId());
			sm.setEmail(member.getEmail());
			sm.setId(member.getId());
			sm.setImg(member.getprofileImg());
			sm.setMajor(sb.getMajor());
			sm.setName(member.getName());
			sm.setPhone(member.getPhone());
			sm.setPw(member.getPw());
			sm.setReg(member.getRegDate());
			sm.setSsn(member.getSsn());
			sm.setSubjects(sb.getSubjects());
			
		} else {
				sm.setId("fail");
		}
			
		System.out.println("서비스로그인결과 ?" +sm.getId());
		return sm;
	}

	@Override
	public int genderCount(String gender) {
		// TODO Auto-generated method stub
		return dao.genderCount(gender);
	}

	@Override
	public void logout(MemberVO member) {
		
		if (member.getId().equals(member.getId()) && 
				member.getPw().equals(member.getPw())) {
			member = null;
		}
		
	}

	@Override
	public List<?> findBy(String keyword) {
		// TODO Auto-generated method stub
		return dao.findByname(keyword);
	}

	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}


