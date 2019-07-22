package com.service.userservice.service;

public interface IUser {
	
	int register(String user, String role, String telNum);
	
	int modifyUser(String user, String telNum);
	
	int addFocus(String user, String city);
	
	int delFocus(String user, String city);
	
	String getFocus(String user);
}
