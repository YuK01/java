package com.human.study;

import java.text.DateFormat;
import java.util.ArrayList;
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
	//메뉴관리
	@RequestMapping("/menu")
	public String menu(Model m) {
		IMenu menu=sqlSession.getMapper(IMenu.class);
		System.out.println("MenuList["+menu.menuList().size()+"]");
		m.addAttribute("menu",menu.menuList());
		return "addMenu";
	}
	
	@RequestMapping("/addMenu")
	public String addmenu(HttpServletRequest hsr) {
		String name=hsr.getParameter("menuname");
		int price=Integer.parseInt(hsr.getParameter("price"));
		String strCode=hsr.getParameter("code");
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		if(strCode.equals("") || strCode.equals(null)) {
			menu.addMenu(name, price);			
		} else {
			int code=Integer.parseInt(strCode);
			menu.updateMenu(code,name,price);
		}		
		return "redirect:/menu";
	}
	@RequestMapping("/deleteMenu")
	public String deleteMenu(HttpServletRequest hsr) {
		int code=Integer.parseInt(hsr.getParameter("code"));
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		menu.deleteMenu(code);
		return "redirect:/menu";
	}
	// 객실 관리
	@RequestMapping("/room")
	public String room(Model m) {
		IMenu menu=sqlSession.getMapper(IMenu.class);
		System.out.println("RoomList["+menu.roomList().size()+"]");
		m.addAttribute("room",menu.roomList());
		m.addAttribute("type",menu.getRoomType());
		return "addRoom";
	}
	@RequestMapping("/addRoom")
	public String addRoom(HttpServletRequest hsr) {
		String name=hsr.getParameter("roomname");
		int type=Integer.parseInt(hsr.getParameter("roomtype"));
		System.out.println("타입코드:"+type);
		int howmany=Integer.parseInt(hsr.getParameter("howmany"));
		int howmuch=Integer.parseInt(hsr.getParameter("howmuch"));
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		menu.addRoom(name, type, howmany, howmuch);
		
//		return "addRoom";
		return "redirect:/room";
	}
	@RequestMapping("/deleteRoom")
	public String deleteRoom(HttpServletRequest hsr) {
		int code=Integer.parseInt(hsr.getParameter("code"));
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		menu.deleteRoom(code);
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
