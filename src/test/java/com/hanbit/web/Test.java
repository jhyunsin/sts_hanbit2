package com.hanbit.web;

import com.hanbit.web.grade.GradeDAOImpl;
import com.hanbit.web.grade.GradeVO;
import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.member.MemberVO;

public class Test {
	public String test() {
		MemberVO m = MemberDAOImpl.getInstance().findById("cho");
		return m.getName();
	}
	public String test1() {
		GradeVO g = GradeDAOImpl.getInstance().findById("cho");
		return g.getId();
	}

	
	public static void main(String[] args) {
		Test t = new Test();
		
		System.out.println("test 클래스에서  " + t.test());
		System.out.println("test 클래스에서  " + t.test1());
		
	}
}
