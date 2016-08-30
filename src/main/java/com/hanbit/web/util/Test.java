package com.hanbit.web.util;

import com.hanbit.web.bank.AccountDAOImpl;
import com.hanbit.web.grade.GradeDAOImpl;
import com.hanbit.web.grade.GradeVO;
import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.member.MemberVO;

public class Test {
	public String test() {
		MemberVO m = MemberDAOImpl.getInstance().findById("cho");
		return m.getName();
	}
	public String testGrade() {
		GradeVO g = GradeDAOImpl.getInstance().findById("cho");
		return g.toString();
	}
//	public String testAccount() {
//		AccountVO a = AccountDAOImpl.getInstance().count("")
//		return a.toString();
//	}

	
	public static void main(String[] args) {
		Test t = new Test();
		
		System.out.println("test 클래스에서  " + t.test());
		System.out.println("test 클래스에서  " + t.testGrade());
//		System.out.println("test 클래스에서  " + t.testAccount());
		
	}
}
