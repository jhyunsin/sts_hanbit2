package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImpl;
import com.hanbit.web.subject.SubjectVO;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectMemberVO;




@Service
public class MemberServiceImpl implements MemberService {
	MemberVO student = null;
	
	private MemberDAOImpl dao = MemberDAOImpl.getInstance();
	private SubjectDAOImpl subjDao = SubjectDAOImpl.getInstance();
	private AccountService accService = AccountServiceImpl.getInstance();
	private MemberVO session;             
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {
		return instance;
	}

	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
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
		return session;
	}

	@Override
	public void update(MemberVO mem) {
		// 3수정
		int result = dao.update(mem);
		if (result ==1) {
			session = this.findById(mem.getId());
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
			session = null;
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
			session = dao.findById(member.getId());
			accService.map();
			sb = subjDao.findById(member.getId());
			sm.setEmail(session.getEmail());
			sm.setId(session.getId());
			sm.setImg(session.getprofileImg());
			sm.setMajor(sb.getMajor());
			sm.setName(session.getName());
			sm.setPhone(session.getPhone());
			sm.setPw(session.getPw());
			sm.setReg(session.getRegDate());
			sm.setSsn(session.getSsn());
			sm.setSubjects(sb.getSubjects());
			
		} else {
				session.setId("fail");
		}
			
		System.out.println("서비스로그인결과 ?" +session.getId());
		return sm;
	}

	@Override
	public int genderCount(String gender) {
		// TODO Auto-generated method stub
		return dao.genderCount(gender);
	}

	@Override
	public void logout(MemberVO member) {
		
		if (member.getId().equals(session.getId()) && 
				member.getPw().equals(session.getPw())) {
			session = null;
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


