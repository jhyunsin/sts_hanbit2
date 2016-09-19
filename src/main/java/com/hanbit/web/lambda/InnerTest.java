package com.hanbit.web.lambda;

public class InnerTest {
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.InnerInstance i = o.new InnerInstance();
		
		Outer.StaticInner osi = new Outer.StaticInner();
		
		System.out.println(i.iv);
		System.out.println(i.SV);
		System.out.println(osi.cv);
	}
}
class Outer{ // public class InnerTest 은 평형관계 종속되지는 않는다 그리고 아래 클래스는 public 을 쓸수 없다
	class InnerInstance{
		int iv = 100;
		final static int SV = 200;
	}
	static class StaticInner{ // static 도 들어올수 있구나... 
		int cv = 300;
	}
}

