package com.hanbit.web.util;

import java.util.List;
import java.util.Map;

/**
 * @date   : 2016. 7. 8.
 * @author : 신재현
 * @file   : CommandService.java
 * @story   :
 */

public interface CommonService {///파라미터값이 없어야 한다
	public List<?> list();
	public List<?> findBy(String keyword);
	public int count();
	public Map<?,?>map();
}
