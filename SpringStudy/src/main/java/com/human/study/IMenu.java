package com.human.study;

import java.util.ArrayList;

public interface IMenu {
	void addMenu(String name,int price);
	void addRoom(String name,int type,int howmany,int howmuch);
	void insertRoomType(int typecode,String typename);
	ArrayList<Room> roomList();
}
