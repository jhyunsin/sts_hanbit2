package com.hanbit.web.grade;

import java.util.List;

public interface GradeService {
//총 7개 패턴
	//exeU
	public int insert(GradeBean grade);
	public int update(GradeBean grade);
	public int delete(int seq);
	// exeQ
	public List<GradeBean> list();
	public List<GradeBean> findById(String id);
	public GradeBean findBySeq(String seq);///아이디역할 관리자는 안다
	public int count(String examDate);//총몇명인지
	
	
	
	
//	public void inputGrade(String score);
//	public int totCal();
//	public int avgCal();
//	public String calGrade();
//	public String showGrade();
//	
	
}
