package com.hanbit.web.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanbit.web.member.MemberController;

@Controller
@RequestMapping("/bank")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("==================AccountController! goMain..");
		return "admin:bank/content.tiles";
	}
	@RequestMapping("/open")
	public String moveRegist() {
		logger.info("AccountController! open()..");
		return "admin:bank/open.tiles";
	} 
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("AccountController! delete()..");
		return "admin:bank/open.tiles";
	} 
	@RequestMapping("/list")
	public String moveList() {
		logger.info("AccountController! list()..");
		return "admin:bank/list.tiles";
	} 
	@RequestMapping("/find")
	public String moveSearch() {
		logger.info("AccountController! find()..");
		return "admin:bank/find.tiles";
	} 
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("AccountController! count()..");
		return "admin:bank/count.tiles";
	} 
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("AccountController! detail()..");
		return "admin:bank/detail.tiles";
	} 
	@RequestMapping("/transaction")
	public String moveTransaction() {
		logger.info("GO TO {}", "transaction");
		return "user:bank/transaction.tiles";
	}
}
