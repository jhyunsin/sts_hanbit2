package com.hanbit.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.constants.Values;
import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.services.impl.MemberServiceImpl;
import com.hanbit.web.util.Pagination;

@Controller  
@SessionAttributes({"user","context","js","css","img"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	public static int PG_SIZE = 5;
	@Autowired MemberDTO member;
	@Autowired MemberServiceImpl service;
	@Autowired Command command;
	@Autowired Retval retval;
	@RequestMapping("/search/{keyField}/{keyword}")
	public MemberDTO find(
			@PathVariable("keyword")String keyword,@PathVariable("keyField")String keyField,
			Model model){
		logger.info("TO SEARCH KEYWORD IS {} : "+keyword);
		command.setKeyword(keyword);
		command.setKeyField(keyField);
		return service.findOne(command);
	}
	@RequestMapping("/logined/header")
	public String loginedHeader(){
		logger.info("TO COUNT CONDITION IS : {}","LOGINED_HEADER");
		return "user/header.jsp";
	}
	@RequestMapping("/admin/header")
	public String adminHeader(){
		logger.info("TO COUNT CONDITION IS : {}","admin_HEADER");
		return "admin/header.jsp";
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
			Model model
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
			model.addAttribute("user", user);
			return user;
		}
	}
	 @RequestMapping(value="/unregist",method=RequestMethod.POST)
	   public @ResponseBody Retval unRegist(@RequestParam("pw") String pw,HttpSession session) {
	      logger.info("GO TO {}","unregist");
	      MemberDTO temp = (MemberDTO) session.getAttribute("user");
	      logger.info("넘어온 PW {}",pw);
	      logger.info("세션 값 PW {}",temp.getPw());
	      if(temp.getPw().equals(pw)){
	        retval.setFlag(service.delete(temp.getId()));
	        logger.info("revtal {}",retval);
	         logger.info("비번 동일 {}",pw);
	      }else{
	         retval.setMessage("www");
	         logger.info("비번 다름 {}",pw);
	      }
	      return retval;
	   }
	//---move---- // 
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GO TO {}","main");
		return "admin:member/content.tiles";
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST,
			consumes="application/json")
	public @ResponseBody Retval signup(@RequestBody MemberDTO param) {
		logger.info("SIGN UP {}","EXEUTE");
		logger.info("SIGN UP ID = {}",param.getId());
		logger.info("SIGN UP PW = {}",param.getPw());
		logger.info("SIGN UP SSN = {}",param.getSsn());
		logger.info("SIGN UP EMAIL = {}",param.getEmail());
		logger.info("SIGN UP PHONE = {}",param.getPhone());
		String[] gen = param.getSsn().split("-");
		String gender="",regDate =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
		int majorSeq=1001;
        switch (Integer.parseInt(gen[1])) {
		case 1: case 3: case 5: case 7:
			gender="MALE";
			break;
		default:
			gender="FEMALE";
			break;
		}
		param.setGender(gender);
		param.setRegDate(regDate);
		param.setMajorSeq(majorSeq);
		param.setProfileImg(param.getId()+".jpg");
		logger.info("SIGN UP GENDER = {}",param.getGender());
		logger.info("SIGN UP REGDATE = {}",param.getRegDate());
		retval.setMessage(service.regist(param));
		//retval.setMessage("success");
		return retval;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public @ResponseBody Retval Update(@RequestBody MemberDTO param, HttpSession session) {
		logger.info("GO TO {}","=======update========");
		MemberDTO temp = (MemberDTO) session.getAttribute("user");
		temp.setPw(param.getPw());
		temp.setEmail(param.getEmail());
		retval.setMessage(service.update(temp));
		session.setAttribute("user", service.update(temp));
		logger.info("update 비번 {}",param.getPw());
		logger.info("update 이멜 {}",param.getEmail());
		return retval;
	} 
	@RequestMapping("/check_dup/{id}")
	public @ResponseBody Retval CheckDup(@PathVariable String id) {
		logger.info("CHECK DUP {}","EXEUTE");
		if (service.existId(id)==1) {
			retval.setFlag("TRUE");
			retval.setMessage("입력하신 ID 사용할수 없습니다");
		}else{
			retval.setFlag("FALSE");
			retval.setMessage("입력하신 ID는 사용가능합니다");
			retval.setTemp(id);
		}
		logger.info("RETVAL FLAG IS {}",retval.getFlag());
		logger.info("RETVAL MSG IS {}",retval.getMessage());
		return retval;
	} 
	
	@RequestMapping("/list/{pgNum}")
	 public @ResponseBody HashMap<String, Object> list(@PathVariable String pgNum, Model model){
	  logger.info("LIST pgNum {}", pgNum);
	  int[] rows = new int[2];
	  int[] pages = new int[3];
	  HashMap<String, Object> map = new HashMap<String, Object>();
	  Retval r = service.count();
	  int totCount = r.getCount();
	  logger.info("LIST totCount {}", totCount);
	  rows = Pagination.getRows(totCount, Integer.parseInt(pgNum), Values.PG_SIZE);
	  pages = Pagination.getPages(totCount, Integer.parseInt(pgNum));
	  command.setStart(rows[0]);
	  command.setEnd(rows[1]);
	 /* model.addAttribute("list", service.list(command));
	  model.addAttribute("pgSize", Values.PG_SIZE);
	  model.addAttribute("totCount", totCount);
	  model.addAttribute("totPg", pages[2]);
	  model.addAttribute("pgNum", Integer.parseInt(pgNum));
	  model.addAttribute("startPg", pages[0]);
	  model.addAttribute("lastPg", pages[1]); */
	  map.put("list", service.list(command));
	  map.put("pgSize", Values.PG_SIZE);
	  map.put("totCount", totCount);
	  map.put("totPg", pages[2]);
	  map.put("pgNum", Integer.parseInt(pgNum));
	  map.put("startPg", pages[0]);
	  map.put("lastPg", pages[1]);
	  map.put("groupSize", Values.GROUP_SIZE);
	  return map;
	 }
	@SuppressWarnings("unchecked")
	@RequestMapping("/search")
	public String search(
			@RequestParam(value="keyField") String keyField, 
			@RequestParam(value="keyword") String keyword, 
			Model model){
		logger.info("SEARCH keyField {}", keyField);
		logger.info("SEARCH keyword {}", keyword);
		command.setKeyField(keyField);
		command.setKeyword(keyword);
		List<MemberDTO> list = (List<MemberDTO>) service.find(command);
		int[] pages = Pagination.getPages(list.size(), 1);
		int[] rows = Pagination.getRows(list.size(), 1, Values.PG_SIZE);
		model.addAttribute("pgSize", Values.PG_SIZE);
		model.addAttribute("totCount", list.size());
		model.addAttribute("totPg", pages[2]);
		model.addAttribute("pgNum", 1);
		model.addAttribute("startPg", pages[0]);
		model.addAttribute("lastPg", pages[1]);
		model.addAttribute("list", list);
		System.out.println(list);
		
		model.addAttribute("list", service.find(command));
		return "admin:member/list.tiles";
	}
	@RequestMapping("/a_detail")
	public String moveDetail(@RequestParam("key")String key) {
		logger.info("GO TO {}","A_detail");
		logger.info("KEY IS {}",key);
		
		return "admin:member/a_detail.tiles";
	} 
	@RequestMapping("/detail")
	public @ResponseBody MemberDTO moveDetail(HttpSession session) {
		logger.info("GO TO {}","detail");
		return (MemberDTO) session.getAttribute("user");
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
	public String logout(SessionStatus status) {
		logger.info("GO TO {}","LOGOUT");
		status.setComplete();
		logger.info("SESSUIN IS {}","CLEAR");
		return "redirect:/";
	} 
//	@RequestMapping("/list")
//	public String moveList() {
//		logger.info("GO TO {}","list");
//		return "admin:member/list.tiles";
//	} 
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
