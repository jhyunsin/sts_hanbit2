/**
 * 
 */
package com.hanbit.web.bank;

import java.util.List;

import com.hanbit.web.util.CommonService;


/**
 * @date : 2016. 6. 20.
 * @author : hb2009
 * @file : AccountService.java
 * @story :
 */
public interface AccountService extends CommonService {


	// 1개설
	public String openAccount(String id);

	// 2 입금
	public void deposit(String depositInfo);

	// 3출금
	public String withdraw(String withdrowInfo);

	// 4수정..사용자의 요청에 의해 비번만 전환가능
	public String updateAccount(AccountBean acc);

	// 5해지
	public int deleteAccount(int AccountNo);

	
	// 7조회(계좌번호)
	public AccountBean findByAccountNo();

	// 8 조회(이름)
	public List<?> findBy(String name);


// 원래 요구사항에는 없었지만, 필요에 따라 생성하는 매소드
	public int restMoney(int accNo);
	





}
