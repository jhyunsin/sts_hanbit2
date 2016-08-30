package com.hanbit.web.grade;

import java.util.List;

public interface GradeDAO {

public int insert(GradeVO bean);
public int update(GradeVO bean);
public int delete(int seq);
public List<GradeVO> list();
public GradeVO findById(String id);
public int count(String examDate);
public GradeVO findBySeq(String seq);
	
}
