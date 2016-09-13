/**
 * 
 */
package com.hanbit.web.domains;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @date : 2016. 6. 16.
 * @author : hb2009
 * @file : Student.java
 * @story :
 */
@Component
@Data
public class MemberDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Getter @Setter private String id;
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
	
	
}
