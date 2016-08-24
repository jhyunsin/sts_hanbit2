package com.hanbit.web.grade;

import java.util.List;
import java.util.Scanner;

public class GradeServiceImpl implements GradeService {

	GradeDAO dao = GradeDAO.getInstance();
	private static GradeServiceImpl instance = new GradeServiceImpl();
	
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	
	private GradeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int insert(GradeBean grade) {
		// 추가
		return	dao.insert(grade);
		 
	}

	@Override
	public int update(GradeBean grade) {
		// TODO Auto-generated method stub
		return dao.update(grade);
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return dao.delete(seq);
	}

	@Override
	public List<GradeBean> list() {
		// TODO Auto-generated method stub
	List<GradeBean> list = 	dao.list();
		return list;
	
	
	}

	@Override
	public List<GradeBean> findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public GradeBean findBySeq(String seq) {
		// TODO Auto-generated method stub
		return dao.findBySeq(seq);
	}

	@Override
	public int count(String examDate) {
		// TODO Auto-generated method stub
		return dao.count(examDate);
	}

	// GradeBean grade = new GradeBean();///
	//
	// @Override
	// public void inputGrade(String score) {
	// String[] gradeArr = score.split(",");
	// grade.setName(gradeArr[0]);
	// grade.setKor(Integer.parseInt(gradeArr[1]));
	// grade.setEng(Integer.parseInt(gradeArr[2]));
	// grade.setMath(Integer.parseInt(gradeArr[3]));
	// }
	//
	// @Override
	// public int totCal() {
	// return grade.getKor() + grade.getEng() + grade.getMath();
	// }
	//
	// @Override
	// public int avgCal() {
	//
	// return (this.totCal()) / 3;
	// }
	//
	// @Override
	// public String calGrade() {
	// String grade = "";
	//// int avg = (this.grade.getKor() + this.grade.getEng() +
	// this.grade.getMath()) / 3;
	// switch (this.avgCal() / 10) {
	// case 10:
	// case 9:
	// grade = "A";
	// break;
	// case 8:
	// grade = "B";
	// break;
	// case 7:
	// grade = "C";
	// break;
	// case 6:
	// grade = "D";
	// break;
	// case 5:
	// grade = "E";
	// break;
	// default:
	// grade = "F";
	// break;
	// }
	//
	// return grade;
	// }
	//
	// @Override
	// public String showGrade() {
	//
	// return grade.toString() + "총점" + totCal() + "평균" + avgCal() + "학점" +
	// calGrade();
	// }

}
