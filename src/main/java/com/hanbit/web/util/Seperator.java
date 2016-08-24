package com.hanbit.web.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date   : 2016. 7. 21.
 * @author : 신재현
 * @file   : Separator.java
 * @story   :
 */

public class Seperator {
	public static CommandFactory factory= new CommandFactory();
	public static Command command;
	public static Command init(HttpServletRequest request, HttpServletResponse response){
		String path = request.getServletPath(); 
		System.out.println("패 스  "+path);
		String temp0= path.split("/")[0];
		System.out.println("템프0 "+temp0);
		String temp = path.split("/")[1];
		System.out.println("템프1 "+temp);
		  
		String directory = temp.substring(0, temp.indexOf("."));
		System.out.println("디렉토리 "+ directory);
		System.out.println("===============");
	
		Enumeration<String> en = request.getParameterNames();
		List<String> list = new ArrayList<String>();
		while (en.hasMoreElements()) {
			String string = (String) en.nextElement();
			list.add(string);
		
		}
		System.out.println("리스트 "+list);
		
		String action = list.contains("action") ? request.getParameter("action") : "move";
		String page = list.contains("page") ? request.getParameter("page") : "main";
		String pageNo = list.contains("pageNo")?request.getParameter("pageNo"):"1";
		String keyword = list.contains("keyword")?request.getParameter("keyword"):"lostChild";
		
		System.out.println("디렉토리 " +directory);
		System.out.println("action " +action);
		System.out.println("page " +page);
		
		 command = factory.createCommand(directory ,action, page);
		
		 return command;		
			}
}
