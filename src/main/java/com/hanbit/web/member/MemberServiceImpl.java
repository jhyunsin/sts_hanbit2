package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImpl;
import com.hanbit.web.subject.SubjectBean;
import com.hanbit.web.subject.SubjectDAO;
import com.hanbit.web.subject.SubjectMember;





public class MemberServiceImpl implements MemberService {
	MemberBean student = null;
	
	private MemberDAO dao = MemberDAO.getInstance();
	private SubjectDAO subjDao = SubjectDAO.getInstance();
	private AccountService accService = AccountServiceImpl.getInstance();//// 5.6번
	private MemberBean session;               /// 로긴정보만 담당하는 인스턴스변수
	private static MemberServiceImpl instance = new MemberServiceImpl();

	public static MemberServiceImpl getInstance() {
		return instance;
	}

	private MemberServiceImpl() {
	//	session = new MemberBean(); 
	}

	@Override
	public String regist(MemberBean bean) {
		// 1등록
		String msg = "";
		MemberBean temp = this.findById(bean.getId());
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
	public MemberBean show() {
		// 2보기
		return session;
	}

	@Override
	public void update(MemberBean mem) {
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
	public void delete(MemberBean mem) {
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
	public MemberBean findById(String findID) {
		// TODO Auto-generated method stub
//		MemberBean t = 
//		MemberBean t2 = new MemberBean(t.getId(),t.getPw(),t.getName(),t.getSsn());
		return dao.findById(findID);
	}

	@Override
	public List<MemberBean> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public List<MemberBean> findByName(String findName) {
		// TODO Auto-generated method stub
		return dao.findByname(findName);
	}
		
	public SubjectMember login(MemberBean member) {
		//로그인
		SubjectMember sm = new SubjectMember();
		SubjectBean sb = new SubjectBean();
		if (dao.login(member)) {
			session = dao.findById(member.getId());
			accService.map();
			sb = subjDao.findById(member.getId());
			sm.setEmail(session.getEmail());
			sm.setId(session.getId());
			sm.setImg(session.getProImg());
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
	public void logout(MemberBean member) {
		
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


