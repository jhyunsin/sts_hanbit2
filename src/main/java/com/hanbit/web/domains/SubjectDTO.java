package com.hanbit.web.domains;


import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @date   : 2016. 7. 26.
 * @author : 신재현
 * @file   : SubjectBean.java
 * @story   :
 */
@Component
@Data
public class SubjectDTO{
	@Getter @Setter private int subjSeq;
	@Getter @Setter private String subjName;
	@Getter @Setter private String id;
	

}
