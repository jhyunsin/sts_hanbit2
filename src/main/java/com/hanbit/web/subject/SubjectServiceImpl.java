package com.hanbit.web.subject;

import org.springframework.stereotype.Service;

/**
 * @date   : 2016. 7. 26.
 * @author : 신재현
 * @file   : SubjectServiceImpl.java
 * @story   :
 */
@Service
public class SubjectServiceImpl implements SubjectService{

	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	SubjectDAOImpl dao = SubjectDAOImpl.getInstance();
	public static SubjectServiceImpl getInstance() {
	return instance;
		}

	private SubjectServiceImpl() {
		// TODO Auto-generated constructor stub
		}
	
	@Override
	public void insert(SubjectVO s) {
		dao.insert(s);
		
	}

}
