/**
 * 
 */
package com.hanbit.web.member;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date : 2016. 6. 16.
 * @author : hb2009
 * @file : Student.java
 * @story :
 */

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
// 클래스 시작
	
	private String id, name, ssn, pw, regDate, gender, proImg, email,phone; // 남 m 여 w
	private int birth;
	
	
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/////////게터세터 시작
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("이메일설정"+email);
		this.email = email;
	}

	

	public MemberBean() {
		/// 기본생성자
	}

	// public final static String
	
	public MemberBean(String id, String pw, String name, String ssn) {// 생성자

		this.id = id;
		this.pw = pw;
		this.name = name;
		this.ssn = ssn;
		this.gender = null;
		String[] arr = new String[2];
		arr = ssn.split("-");

		switch (Integer.parseInt(arr[1]) % 2) {
		case 1:
			this.gender = "남";
			break;

		default:
			this.gender = "여";

			break;
		}

	}

	public String getProImg() {
		return proImg;
	}

	public void setProImg(String proImg) {
		this.proImg = proImg;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;

	}

	public void setRegDate() {
		String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		this.regDate = now;
	}

	public void setRegDate(String regDate) {/// 오버라이딩
		this.regDate = regDate;
	}

	public void setGenderAndBirth(String ssn) {///////birth와 gender를 통합
		String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		String[] ssnArr = ssn.split("-");
		String[] nowArr = now.split("-");
		int ssnBirth = (Integer.parseInt(ssnArr[0]));
		int ssnGender = (Integer.parseInt(ssnArr[1]));
		int thisYear = (Integer.parseInt(nowArr[0]));
		int age = 0;
		switch (ssnGender) {
		case 1: case 5: 
			this.gender="남"; 
			System.out.println("올해:"+thisYear);
			System.out.println("생년월일:"+ssnBirth);
		//	age = ageResult2 - (1900-(this/10000));
		//  나이를 구하려고 했으나 일단 보류
			this.birth = ssnBirth;
			break;
		case 3: case 7:
			this.gender="남"; 
			this.birth = ssnBirth;
			break;
		case 2: case 6:
			this.gender="여";
			this.birth = ssnBirth;
			break;
		case 4: case 8:
			this.gender="여";
			this.birth = ssnBirth;
			break;
		default:
			System.out.println("잘못된값이 입력됨");
		}
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	

	public String getId() {
		return this.id;
	}

	public String getPw() {
		return this.pw;
	}

	public String getName() {
		return this.name;
	}

	public String getRegDate() {
		return this.regDate;
	}

	public String getGender() {
		return this.gender;
	}

	public String getSsn() {
		return this.ssn;
	}

//	public int getbirth() {
//		return this.birth;
//	}
	
	@Override
	public String toString() {
		return "학생 [이메일 : "+email+"아이디=" + id + ", 이름=" + name + "," + ssn + ", 비밀번호=****" + " 등록일=" + regDate + ", gender="
				+ gender + ", birth=" + birth + "]";
	}

}
