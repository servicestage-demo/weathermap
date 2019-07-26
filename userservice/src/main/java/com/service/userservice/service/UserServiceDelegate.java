package com.service.userservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.userservice.dao.User;
import com.service.userservice.dao.UserMapper;

@Component
public class UserServiceDelegate implements IUser {
	
	private final static Logger logger = LoggerFactory.getLogger(UserServiceDelegate.class);

	private final static String SEPARATOR = ",";

	@Autowired
	private UserMapper userMapper;

	@Override
	public String register(String userName, String telNum) {
		if (userMapper.getUserInfo(userName) == null) {
			userMapper.createUser(new User().setUserName(userName).setTelNum(telNum).setFocusCity(""));
			logger.info("user {} register.", userName);
		}
		return userName;
	}

	@Override
	public int modifyUser(String userName, String telNum) {
		User user = userMapper.getUserInfo(userName);
		if (user != null) {
			user.setTelNum(telNum);
			userMapper.modifyUser(user);
			logger.info("modify user {} telNum {}.", userName, telNum);
		}
		return 200;
	}

	@Override
	public int addFocus(String userName, String city) {
		User user = userMapper.getUserInfo(userName);
		if (user != null) {
			user.setFocusCity(user.getFocusCity() + SEPARATOR + city);
			userMapper.modifyFocus(user);
			logger.info("user {} add focus {}.", userName, city);
		}
		return 200;
	}

	@Override
	public int delFocus(String userName, String city) {
		User user = userMapper.getUserInfo(userName);
		if (user != null) {
			String oldFocus = user.getFocusCity();
			if (null != oldFocus) {
				String[] cities = oldFocus.split(SEPARATOR);
				String newFocus = "";
				for (String c : cities) {
					if (!city.equals(c) && !c.isEmpty()) {
						newFocus = c + SEPARATOR + newFocus;
					} else {
						logger.info("user {} delete focus {}.", userName, city);
					}
				}
				user.setFocusCity(newFocus);
				userMapper.modifyFocus(user);

			}
		}
		return 200;
	}

	@Override
	public String[] getFocus(String userName) {
		String focus = "";
		User user = userMapper.getUserInfo(userName);
		if (user != null) {
			focus = user.getFocusCity();
		}
		logger.info("user {} get focus {}.", userName, focus);
		return focus == null ? new String[0] : focus.split(SEPARATOR);
	}
}
