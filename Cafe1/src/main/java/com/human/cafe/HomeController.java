package com.human.cafe;

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

import com.human.cafe.ICafe;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		ICafe cafe=sqlSession.getMapper(ICafe.class);
//		ArrayList<Menu> ml=cafe.getMenuList();
//		ArrayList<Cafe_sales> sl=cafe.getSales();
//		System.out.println("menu length:"+ml.size());
		model.addAttribute("ml",cafe.getMenuList());
		model.addAttribute("sl",cafe.getSales());
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	public String list() {		
		ICafe cafe=sqlSession.getMapper(ICafe.class);
		ArrayList<Menu> ml=cafe.getMenuList();
		//JASONObject -> JASONArray -> toString -> writer().print()
		// [{name:'americano',price:2000},{name:'mocca',price:3000},...,{name:'xxx',price:yyy}]
		JSONArray ja=new JSONArray();
		for(int i=0; i<ml.size(); i++) {
			JSONObject jo=new JSONObject();
			jo.put("code",ml.get(i).getCode());
			jo.put("name",ml.get(i).getName());
			jo.put("price",ml.get(i).getPrice());
			ja.add(jo);
		}
		return ja.toString();
	}
	@ResponseBody
	@RequestMapping(value="/insertMenu",method=RequestMethod.POST,
	               produces="application/json;charaset=utf-8")
	public String insertMenu(HttpServletRequest hsr) {
	   String retval="";
	   try {
		   	String name=hsr.getParameter("name");
		   	int price=Integer.parseInt(hsr.getParameter("price"));
	      
		   	ICafe cafe=sqlSession.getMapper(ICafe.class);
		   	cafe.insertMenu(name,price);
		   	retval="ok";
	   } catch(Exception e) {
		   	retval="fail";
	   }
	   return retval;
	}
	@ResponseBody
	@RequestMapping(value="/updateMenu",method=RequestMethod.POST)
	public String updateMenu(HttpServletRequest hsr) {
	   String retval="";
	   try {
		   	int code=Integer.parseInt(hsr.getParameter("code"));
		   	String name=hsr.getParameter("name");
		   	int price=Integer.parseInt(hsr.getParameter("price"));
	       
		   	ICafe cafe=sqlSession.getMapper(ICafe.class);
		   	cafe.updateMenu(code,name,price);
		   	retval="ok";
	   } catch(Exception e) {
		   	retval="fail";
	   }
	   return retval;
	}
	@ResponseBody
	@RequestMapping(value="/deleteMenu",method=RequestMethod.POST)
	public String deleteMenu(HttpServletRequest hsr) {
	   String retval="";
	   try {
		   	int code=Integer.parseInt(hsr.getParameter("code"));
	       
		   	ICafe cafe=sqlSession.getMapper(ICafe.class);
		   	cafe.deleteMenu(code);
		   	retval="ok";
	   } catch(Exception e) {
		   	retval="fail";
	   }
	   return retval;
	}
	@ResponseBody
	@RequestMapping(value="/insertSales",method=RequestMethod.POST,
					produces="application/json;charaset=utf-8")
	public String insertSales(HttpServletRequest hsr) {
	    String retval="";
	    try {
	    	 int menu_code=Integer.parseInt(hsr.getParameter("menu_code"));
	    	 int qty=Integer.parseInt(hsr.getParameter("qty"));
	    	 int price=Integer.parseInt(hsr.getParameter("price"));
	    	 String mobile=hsr.getParameter("mobile");
	         
	    	 ICafe cafe=sqlSession.getMapper(ICafe.class);
	    	 cafe.insertSales(menu_code,qty,price,mobile);
	    	 retval="ok";
	   } catch(Exception e) {
//		   	 System.out.println(e.getMessage());
		   	 retval="fail";
	   }
	   return retval;
	}
	
	@ResponseBody
	@RequestMapping(value="/salesMenu",method=RequestMethod.POST,
			produces="application/json;charset=utf-8")
	public String salesMenu() {
		ICafe cafe=sqlSession.getMapper(ICafe.class);
		ArrayList<Sales> ml=cafe.SalesMenu();
		JSONArray ja=new JSONArray();
		for(int i=0; i<ml.size(); i++) {
			JSONObject jo=new JSONObject();
			jo.put("name",ml.get(i).getName());
			jo.put("total", ml.get(i).getTotal());
			ja.add(jo);
		}
		return ja.toString(); // JSON format data
	}
	@ResponseBody
	@RequestMapping(value="/salesMobile",method=RequestMethod.POST,
			produces="application/json;charset=utf-8")
	public String salesMobile() {
		ICafe cafe=sqlSession.getMapper(ICafe.class);
		ArrayList<Sales> ml=cafe.SalesMobile();
		JSONArray ja=new JSONArray();
		for(int i=0; i<ml.size(); i++) {
			JSONObject jo=new JSONObject();
			jo.put("mobile",ml.get(i).getName());
			jo.put("total", ml.get(i).getTotal());
			ja.add(jo);
		}
		return ja.toString(); // JSON format data
	}

}
