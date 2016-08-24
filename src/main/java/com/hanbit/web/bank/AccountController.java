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
		return "bank/content.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("AccountController! regist()..");
		return "bank/regist.tiles";
	} 
	@RequestMapping("/deposit")
	public String moveDeposit() {
		logger.info("AccountController! deposit()..");
		return "bank/deposit.tiles";
	} 
	@RequestMapping("/withdraw")
	public String moveWithdraw() {
		logger.info("AccountController! withdraw()..");
		return "bank/withdraw.tiles";
	} 
	@RequestMapping("/update")
	public String moveUdate() {
		logger.info("AccountController! update()..");
		return "bank/update.tiles";
	} 
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("AccountController! delete()..");
		return "bank/delete.tiles";
	} 
	@RequestMapping("/list")
	public String moveList() {
		logger.info("AccountController! list()..");
		return "bank/list.tiles";
	} 
	@RequestMapping("/search")
	public String moveSearch() {
		logger.info("AccountController! search()..");
		return "bank/search.tiles";
	} 
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("AccountController! count()..");
		return "bank/count.tiles";
	} 
}
