package com.hanbit.web.util;

import com.hanbit.web.constants.Values;

/**
 * @date   : 2016. 7. 5.
 * @author : 신재현
 * @file   : DatabaseFactory.java
 * @story   :
 */

public class DatabaseFactory {// 생성 자체를 공장한테 준다

	public static Database createDatabase(Vendor vendor,String id,String pw){// 벤더에 멀 넣을 지는 사용자가 선택한다
		String driver="",url="";
		
		switch (vendor) {
		case ORACLE:
			driver = Values.ORACLE_DRIVER;
			url = Values.ORACLE_URL;
			break;
		case MYSQL:
			driver = Values.MYSQL_DRIVER;
			url = Values.MYSQL_URL;
			break;
		case MSSQL:
			
			break;
		case MARIADB:
			
			break;

		default:
			break;
		}
		return new Database(driver,url,id,pw);	
	}
	
}
