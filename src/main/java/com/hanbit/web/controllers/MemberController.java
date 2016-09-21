package com.hanbit.web.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.services.impl.MemberServiceImpl;

@Controller  
@SessionAttributes({"user","context","js","css","img"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberDTO member;
	@Autowired MemberServiceImpl service;
	@Autowired Command command;
	@RequestMapping("/search/{option}/{keyword}")
	public MemberDTO find(@PathVariable("option") String option,
			@PathVariable("keyword")String keyword,
			Model model){
		logger.info("TO SEARCH KEYWORD IS {} : "+keyword);
		logger.info("TO SEARCH OPTION IS {} : "+option);
		command.setKeyword(keyword);
		command.setOption(option);
		return service.findOne(command);
	}
	@RequestMapping("/logined/header")
	public String loginedHeader(){
		logger.info("TO COUNT CONDITION IS : {}","LOGINED_HEADER");
		return "user/header.jsp";
	}
	@RequestMapping(value="/count/{option}",method=RequestMethod.GET,consumes="application/json")
	public Model count(@PathVariable("option") String option,Model model){
		logger.info("TO COUNT CONDITION IS : {}",option);
		model.addAttribute("count",service.count());
		return model;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody MemberDTO Login(
			@RequestParam("id")String id,
			@RequestParam("pw")String pw,
			HttpSession session
			) {
		logger.info("로그인시 넘어온 id {}",id);
		logger.info("로그인시 넘어온 pw {}",pw);
		member.setId(id);
		member.setPw(pw);
		//member = service.login(member);
		MemberDTO user = service.login(member);
		if (member.getId().equals("NONE")) {
			logger.info("COntroller LOGIN","FAIL");
			return user;
		}else{
			logger.info("COntroller LOGIN","SUCCESS");
			session.setAttribute("user", user);
			return user;
		}
	}
	//---move---- // 
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
	@RequestMapping("/a_detail")
	public String moveDetail(@RequestParam("key")String key) {
		logger.info("GO TO {}","A_detail");
		logger.info("KEY IS {}",key);
		
		return "admin:member/a_detail.tiles";
	} 
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("GO TO {}","detail");
		return "user:member/detail.tiles";
	} 
	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("GO TO {}","update");
		return "user:member/update.tiles";
	} 
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("GO TO {}","delete");
		return "user:member/delete.tiles";
	} 
	@RequestMapping("/login")
	public String Login() {
		logger.info("GO TO {}","login");
		return "public:member/login.tiles";
	} 
	@RequestMapping("/logout")
	public String moveLogout(SessionStatus status) {
		logger.info("GO TO {}","LOGOUT");
		status.setComplete();
		logger.info("SESSUIN IS {}","CLEAR");
		return "public:member/logout.tiles";
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
	 @RequestMapping("/content")
	 public String moveUserContent() {
	  logger.info("GO TO {}", "content");
	  return "user:user/content.tiles";
	 }
	 @RequestMapping("/kaup")
	 public String moveKaup() {
	  logger.info("GO TO {}", "kaup");
	  return "user:user/kaup.tiles";
	 }
	 @RequestMapping("/rock_scissor_paper")
	 public String moveRockScissorPaper() {
	  logger.info("GO TO {}", "rock_scissor_paper");
	  return "user:user/rock_scissor_paper.tiles";
	 }
	 
	 @RequestMapping("/lotto")
	 public String movelotto() {
	  logger.info("GO TO {}", "lotto");
	  return "user:user/lotto.tiles";
	 }
}
