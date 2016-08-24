/**
 * 
 */
package com.hanbit.web.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @date   : 2016. 6. 20.
 * @author : hb2009
 * @file   : AccountServiceIMmpl.java
 * @story  : 계좌 인터페이스
  */
public class AccountServiceImpl implements AccountService {
	AccountDAO dao = AccountDAO.getInstance();
	private Map<?,?> map ; ///인스턴스변수  ---- private을 걸어야 은닉화
	private static AccountServiceImpl instance = new AccountServiceImpl();
	public static AccountServiceImpl getInstance() {
	return instance;
}

	private AccountServiceImpl() {
	map = new HashMap<String,AccountMemberBean>();
	}

	@Override
	public String openAccount(String id) {
		// 개설
		AccountBean acc = new AccountBean();
		acc.setAccountNo();
		acc.setId(id);
		acc.setMoney(0);
		String msg = "";		
		if (dao.insertAccount(acc)==1) {
			msg = "계좌 생성완료";
		} else {
			msg = "계좌 생성실패";
		}
				return msg;
	}

	@Override
	public void deposit(String depositInfo) {
		// 입금
		String[] arr = depositInfo.split(",");
		AccountBean acc = new AccountBean();
		acc.setAccountNo(Integer.parseInt(arr[0]));
		int money = this.restMoney(Integer.parseInt(arr[0])) + Integer.parseInt(arr[1]);
		acc.setMoney(money);
		dao.deposit(acc);
	}

	@Override
	public String withdraw(String withdrowInfo) {
		// 출금
		String result = "";
		String[] arr = withdrowInfo.split(",");
		AccountBean acc = new AccountBean();
		acc.setAccountNo(Integer.parseInt(arr[0]));
		int restMoney = this.restMoney(Integer.parseInt(arr[0]));
		int withdrawMoney = Integer.parseInt(arr[1]);
		if (restMoney < withdrawMoney) {
			result = "잔액이 부족합니다";
		}else {
		
		acc.setMoney(restMoney-withdrawMoney);
		dao.withdraw(acc);
		result = "잔액 : "+String.valueOf(this.restMoney(Integer.parseInt(arr[0])));
		}
		
		return result;
	}

	@Override
	public String updateAccount(AccountBean acc) {
		// 비밀번호 수정
		String result = "";
//	if (dao.fina) {
//		
//	}
		 
		 return "";
	}

	@Override
	public int deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(accountNo);
	}

	@Override
	public List<?> list() {
		// 전체조회
		
		return dao.selectAll(); ///sql 문을 메소드 이름을 잡는다
	}

	@Override
	public AccountBean findByAccountNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findBy(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public int restMoney(int accNo) {
		// TODO Auto-generated method stub
		return dao.selectMoney(accNo);
	}

	@Override
	public Map<?, ?> map() {
	map = new HashMap<String,AccountMemberBean>();
	map = dao.selectMap();	
	return map;
	}


	


	

	

	
	
}