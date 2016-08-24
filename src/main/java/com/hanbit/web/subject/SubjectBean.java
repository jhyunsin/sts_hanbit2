package com.hanbit.web.subject;

import java.io.Serializable;

/**
 * @date   : 2016. 7. 26.
 * @author : 신재현
 * @file   : SubjectBean.java
 * @story   :
 */

public class SubjectBean implements Serializable {

	private static final long serialVersionUID = 1L;
		private String id, major,subjects;
		private int subjseq;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
		}
		public String getSubjects() {
			return subjects;
		}
		public void setSubjects(String subjects) {
			this.subjects = subjects;
		}
		public int getSubjseq() {
			return subjseq;
		}
		public void setSubjseq(int subjseq) {
			this.subjseq = subjseq;
		}


}
