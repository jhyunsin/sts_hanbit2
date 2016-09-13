package com.hanbit.web.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.GradeDTO;
public interface GradeMapper {

public int insert(GradeDTO bean);
public int update(GradeDTO bean);
public int delete(int seq);
public List<GradeDTO> list();
public GradeDTO findById(String id);
public int count(String examDate);
public GradeDTO findBySeq(String seq);
	
}
