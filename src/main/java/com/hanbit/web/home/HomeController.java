package com.hanbit.web.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)// post
	public String home(Locale locale, Model model) {
		 //syso 역할
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		logger.info("SERVER START TIME : {}",formattedDate);
		return "public:public/content.tiles";
	}
	@RequestMapping("/public/school_info")
	public String moveSchoolInfo(){
		logger.info("HomeController! school_info..");
		return "public:public/school_info.tiles";
	}
	@RequestMapping("/public/way")
	public String moveWay(){
		logger.info("HomeController! way..");
		return "public:public/way.tiles";
	}

}
