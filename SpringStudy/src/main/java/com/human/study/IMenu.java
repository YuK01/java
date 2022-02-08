package com.human.study;

import java.util.ArrayList;

public interface IMenu {
	void addMenu(String name,int price);
	void deleteMenu(int code);
	void updateMenu(int code,String name,int price);
	void addRoom(String name,int type,int howmany,int howmuch);
	void insertRoomType(int typecode,String typename);
	void deleteRoom(int code);
	void updateRoom(int code,String name,int type,int howmany,int howmuch);
	ArrayList<Room> roomList();
	ArrayList<Menu> menuList();
	ArrayList<RoomType> getRoomType();
	ArrayList<Employee> getEmpList();
//	ArrayList<Employee> getEmp(int emp_id);
	Employee getEmp(int emp_id);
}
