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
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	public String menu() {// jsp파일 보여주기용		
		return "addMenu";
	}
	@ResponseBody
	@RequestMapping(value="/menulist", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public String menulist() {
//		System.out.println("menuList strart");
		IMenu menu=sqlSession.getMapper(IMenu.class);
		ArrayList<Menu> ml=menu.menuList();
		System.out.println("MenuList["+ml.size()+"]");
		// menu.menuList()에는 메뉴명,가격이 여러개가 쌓여있음 
		
		// JSONArray, JSONObject
		JSONArray ja=new JSONArray();
		for(int i=0;i<ml.size(); i++) {// ArrayList -> JSON
			JSONObject jo=new JSONObject();
			jo.put("code",ml.get(i).getCode());
			jo.put("name",ml.get(i).getName());
			jo.put("price",ml.get(i).getPrice());
			ja.add(jo);
		}
		return ja.toString();
//		m.addAttribute("menu",menu.menuList());
//		return "addMenu";
	}
	
	@RequestMapping(value="/addMenu",method = RequestMethod.POST)
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
	@RequestMapping(value="/deleteMenu",method = RequestMethod.GET)
	public String deleteMenu(HttpServletRequest hsr) {
		int code=Integer.parseInt(hsr.getParameter("code"));
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		menu.deleteMenu(code);
		return "redirect:/menu";
	}
	// 객실 관리
	@RequestMapping("/room")
	public String room() {
//		IMenu menu=sqlSession.getMapper(IMenu.class);
//		System.out.println("RoomList["+menu.roomList().size()+"]");
//		m.addAttribute("room",menu.roomList());
//		m.addAttribute("type",menu.getRoomType());
		return "addRoom";
	}
	@ResponseBody
	@RequestMapping(value="/roomlist",method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public String roomlist() {
		IMenu menu=sqlSession.getMapper(IMenu.class);
		ArrayList<Room> rl=menu.roomList();
		System.out.println("RoomList["+rl.size()+"]");
		JSONArray ja=new JSONArray();
		for(int i=0;i<rl.size(); i++) {// ArrayList -> JSON
			JSONObject jo=new JSONObject();
			jo.put("code",rl.get(i).getCode());
			jo.put("name",rl.get(i).getName());
			jo.put("type_name",rl.get(i).getType_name());
			jo.put("howmany",rl.get(i).getHowmany());
			jo.put("howmuch",rl.get(i).getHowmuch());
			ja.add(jo);
		}
		return ja.toString();
	}
	@ResponseBody
	@RequestMapping(value="/typelist",method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public String typelist() {
		IMenu menu=sqlSession.getMapper(IMenu.class);
		ArrayList<RoomType> rtl=menu.getRoomType();
		System.out.println("RoomTypeList["+rtl.size()+"]");
		JSONArray ja=new JSONArray();
		for(int i=0;i<rtl.size(); i++) {// ArrayList -> JSON
			JSONObject jo=new JSONObject();
			jo.put("code",rtl.get(i).getCode());
			jo.put("name",rtl.get(i).getName());
			ja.add(jo);
		}
		return ja.toString();
	}
	@RequestMapping("/addRoom")
	public String addRoom(HttpServletRequest hsr) {
		String roomcode=hsr.getParameter("code");
		String name=hsr.getParameter("roomname");
		int type=Integer.parseInt(hsr.getParameter("roomtype"));
		System.out.println("타입코드:"+type);
		int howmany=Integer.parseInt(hsr.getParameter("howmany"));
		int howmuch=Integer.parseInt(hsr.getParameter("howmuch"));
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		if(roomcode.equals("") || roomcode.equals(null)) {
			menu.addRoom(name, type, howmany, howmuch);
		} else {
			int code=Integer.parseInt(roomcode);
			menu.updateRoom(code, name, type, howmany, howmuch);
		}		
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
	// 직원명단 관리
	@RequestMapping("/emplist")
	public String getEmpList() {
		return "emplist";
	}
	@ResponseBody
	@RequestMapping(value="/empview",method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public String empList(HttpServletRequest hsr) {
		String keyword=hsr.getParameter("kw");
		
		IMenu menu=sqlSession.getMapper(IMenu.class);
		
		
		if(keyword.equals("") || keyword.equals(null)) return "";
		int emp_id=Integer.parseInt(keyword);
		Employee emp=menu.getEmp(emp_id);
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject();
		jo.put("emp_id",emp.getEmployee_id());
		jo.put("emp_name",emp.getEmp_name());
		jo.put("phone",emp.getPhone_number());
		jo.put("hire_d",emp.getHire_date());
		jo.put("m_id",emp.getManager_id());
		ja.add(jo);
		
//		ArrayList<Employee> el=menu.getEmpList();
//		System.out.println("RoomTypeList["+el.size()+"]");
//		JSONArray ja=new JSONArray();
//		for(int i=0;i<el.size(); i++) {// ArrayList -> JSON
//			JSONObject jo=new JSONObject();
//			jo.put("emp_id",el.get(i).getEmployee_id());
//			jo.put("emp_name",el.get(i).getEmp_name());
//			jo.put("phone",el.get(i).getPhone_number());
//			jo.put("hire_d",el.get(i).getHire_date());
//			jo.put("m_id",el.get(i).getManager_id());
//			ja.add(jo);
//		}
		return ja.toString();
	}
}
