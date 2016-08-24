package com.hanbit.web.subject;

/**
 * @date   : 2016. 7. 26.
 * @author : 신재현
 * @file   : SubjectServiceImpl.java
 * @story   :
 */

public class SubjectServiceImpl implements SubjectService{

	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	SubjectDAO dao = SubjectDAO.getInstance();
	public static SubjectServiceImpl getInstance() {
	return instance;
		}

	private SubjectServiceImpl() {
		// TODO Auto-generated constructor stub
		}
	
	@Override
	public void insert(SubjectBean s) {
		dao.insert(s);
		
	}

}
