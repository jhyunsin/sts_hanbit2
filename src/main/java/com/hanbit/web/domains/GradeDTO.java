package com.hanbit.web.domains;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Component
@Data

public class GradeDTO {
	@Getter @Setter private String name;
	@Getter @Setter private String ssn;
	@Getter @Setter private String pw;
	@Getter @Setter private String regDate;
	@Getter @Setter private String gender;
	@Getter @Setter private String profileImg;
	@Getter @Setter private String email;
	@Getter @Setter private String phone;
	@Getter @Setter private String role;
	@Getter @Setter private int birth;
	@Getter @Setter private int gradeSeq;
	@Getter @Setter private String grade;
	@Getter @Setter private String term;
	@Getter @Setter private String id;
	@Getter @Setter private String examSeq;
	@Getter @Setter private String score;
	@Getter @Setter private String subjSeq;
	@Getter @Setter private String subjName;

}
