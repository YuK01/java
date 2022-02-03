package com.human.cafe;

import java.util.ArrayList;

public interface ICafe {
	ArrayList<Menu> getMenuList();
	ArrayList<Cafe_sales> getSales();
	ArrayList<Sales> SalesMenu();
	ArrayList<Sales> SalesMobile();
	void insertMenu(String name,int price);
	void updateMenu(int code,String name,int price);
	void deleteMenu(int code);
	void insertSales(int menu_code,int qty,int total,String mobile);
}
