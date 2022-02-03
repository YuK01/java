package com.human.study;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/menu")
	public String menu() { return "addMenu"; }
	
	@RequestMapping("/addMenu")
	public String addmenu(HttpServletRequest hsr) {
		String name=hsr.getParameter("menuname");
		int price=Integer.parseInt("price");
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		menu.addMenu(name, price);		
		return "addMenu";
	}
	// 객실 관리
	@RequestMapping("/room")
	public String room(Model m) {
		IMenu menu=sqlSession.getMapper(IMenu.class);
		System.out.println(menu.roomList().size());
		m.addAttribute("room",menu.roomList());
		return "addRoom";
	}
	@RequestMapping("/addRoom")
	public String addRoom(HttpServletRequest hsr) {
		String name=hsr.getParameter("roomname");
		int type=Integer.parseInt(hsr.getParameter("roomtype"));
		int howmany=Integer.parseInt(hsr.getParameter("howmany"));
		int howmuch=Integer.parseInt(hsr.getParameter("howmuch"));
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		menu.addRoom(name, type, howmany, howmuch);
		
//		return "addRoom";
		return "redirect:/room";
	}
	// 객실타입 관리
	@RequestMapping("/typeadd")
	public String type() { return "addRoomType"; }
	@RequestMapping("/addtype")
	public String addtype(HttpServletRequest hsr) {
		int type=Integer.parseInt(hsr.getParameter("typecode"));
		String name=hsr.getParameter("typename");
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		menu.insertRoomType(type, name);
		return "addRoomType";
	}
}
