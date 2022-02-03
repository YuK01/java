package com.human.study;

public class Room {
	private int code;
	private String name;
	private String type_name;
	private int howmany;
	private int howmuch;
	
	public Room() {
	}
	public Room(int code, String name, String type_name, int howmany, int howmuch) {
		this.code = code;
		this.name = name;
		this.type_name = type_name;
		this.howmany = howmany;
		this.howmuch = howmuch;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getHowmany() {
		return howmany;
	}
	public void setHowmany(int howmany) {
		this.howmany = howmany;
	}
	public int getHowmuch() {
		return howmuch;
	}
	public void setHowmuch(int howmuch) {
		this.howmuch = howmuch;
	}
	
}
