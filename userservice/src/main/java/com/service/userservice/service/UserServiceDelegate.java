package com.service.userservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.userservice.dao.User;
import com.service.userservice.dao.UserMapper;

@Component
public class UserServiceDelegate {
	private final static Logger logger = LoggerFactory.getLogger(UserServiceDelegate.class);

	@Autowired
	private UserMapper userMapper;

	public int register(String userName, String telNum) {
		logger.info("user {} register.", userName);
		if (userMapper.getUserInfo(userName) == null) {
			userMapper.createUser(new User().setUserName(userName).setTelNum(telNum).setFocusCity(""));
		}
		return 200;
	}

	public int modifyUser(String user, String telNum) {
		logger.info("user {} modify.", user);
		return 0;
	}

	public int addFocus(String user, String city) {
		logger.info("user {} add focus {}.", user, city);
		return 0;
	}

	public int delFocus(String user, String city) {
		logger.info("user {} add delfocus {}.", user, city);
		return 0;
	}

	public String getFocus(String userName) {
		logger.info("user {} get focus {}.", userName);
		User user = userMapper.getUserInfo(userName);
		if (user != null) {
			return user.getFocusCity();
		}
		return "DEFAULT";
	}
}
