package com.hanbit.web.bank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccountDAO {
	public int insertAccount(AccountVO acc);
	public int getRestMoney(int accountNo);
	public void deposit(AccountVO bean);
	public void withdraw(AccountVO acc);
	public int selectMoney(int accNo);
	public int deleteAccount(int accountNo);
	public int count();
	public List<?> selectAll();
	public Map<?, ?> selectMap();
	public int updageAccount(AccountVO acc);
}
