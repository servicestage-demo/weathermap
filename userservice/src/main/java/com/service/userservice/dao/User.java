package com.service.userservice.dao;

public class User {
	private int id;
	private String userName;
	private String telNum;
	private String focusCity;

	public int getId() {
		return id;
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getTelNum() {
		return telNum;
	}

	public User setTelNum(String telNum) {
		this.telNum = telNum;
		return this;
	}

	public String getFocusCity() {
		return focusCity;
	}

	public User setFocusCity(String focusCity) {
		this.focusCity = focusCity;
		return this;
	}

	
}
