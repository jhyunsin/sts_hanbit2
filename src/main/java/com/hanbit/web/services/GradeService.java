package com.hanbit.web.services;

import java.util.List;

import com.hanbit.web.domains.GradeDTO;

public interface GradeService {
//총 7개 패턴
	//exeU
	public int insert(GradeDTO grade);
	public int update(GradeDTO grade);
	public int delete(int seq);
	// exeQ
	public List<GradeDTO> list();
	public GradeDTO findById(String id);
	public GradeDTO findBySeq(String seq);///아이디역할 관리자는 안다
	public int count(String examDate);//총몇명인지
	
	
	
	
//	public void inputGrade(String score);
//	public int totCal();
//	public int avgCal();
//	public String calGrade();
//	public String showGrade();
//	
	
}
