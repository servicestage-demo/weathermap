package com.service.userservice.dao;

public interface UserMapper {
	
	void createUser(User userInfo);

	User getUserInfo(String userName);
}
