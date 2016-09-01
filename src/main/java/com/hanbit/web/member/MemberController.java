package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hanbit.web.subject.SubjectMemberVO;

@Controller  
@SessionAttributes({"user","context","js","css","img"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	
	@RequestMapping("/search")
	public String find(@RequestParam("keyword") String keyword,
			@RequestParam("search_option")String option,
			@RequestParam("context")String context,
			Model model){
		MemberVO member =  service.findById(keyword);
		logger.info("MemberController! findBy id : {}",member.getName());
		System.out.println("검색어: "+keyword);
		System.out.println("옵션: "+option);
		System.out.println("context : "+context);
		System.out.println("== NAME == "+member.getName());
		System.out.println("이미지:"+member.getprofileImg());
		model.addAttribute("member",member);
		model.addAttribute("img", context+ "/resources/img");
		return "admin:member/detail.tiles";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String Login(
			@RequestParam("id")String id,
			@RequestParam("pw")String pw,
			@RequestParam("context")String context,
			Model model) {
		logger.info("로그인시 넘어온 id {}",id);
		logger.info("로그인시 넘어온 pw {}",pw);
		logger.info("CONTEXT {}",context);
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		SubjectMemberVO sm = service.login(member);
		model.addAttribute("user", sm);
		model.addAttribute("context", context);
		model.addAttribute("js", context+"/resources/js"); ///jsp에서 ${} E.L표기 법으로 쓰기 위해서 model에 ATTR을 추가해주는 모습
		model.addAttribute("css", context+"/resources/css");
		model.addAttribute("img", context+"/resources/img");
		return "user:user/content.tiles";
	}
	//---move----
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GO TO {}","main");
		return "admin:member/content.tiles";
	}
	
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("GO TO {}","regist");
		return "public:member/regist.tiles";
	} 
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("GO TO {}","detail");
		return "member/detail.tiles";
	} 
	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("GO TO {}","update");
		return "member/update.tiles";
	} 
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("GO TO {}","delete");
		return "public:member/delete.tiles";
	} 
	@RequestMapping("/login")
	public String Login() {
		logger.info("GO TO {}","login");
		return "public:member/login.tiles";
	} 
	@RequestMapping("/logout")
	public String moveLogout() {
		logger.info("GO TO {}","logout");
		return "member/logout.tiles";
	} 
	@RequestMapping("/list")
	public String moveList() {
		logger.info("GO TO {}","list");
		return "admin:member/list.tiles";
	} 
	@RequestMapping("/findBy")
	public String moveFindBy() {
		logger.info("GO TO {}","findBy");
		return "admin:member/findBy.tiles";
	} 
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("GO TO {}","count");
		return "admin:member/count.tiles";
	} 

}
