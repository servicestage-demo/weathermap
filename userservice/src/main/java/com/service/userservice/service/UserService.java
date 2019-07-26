package com.service.userservice.service;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestSchema(schemaId = "userservice")
@RequestMapping(path = "/userservice", produces = MediaType.APPLICATION_JSON)
public class UserService {

	@Autowired
	private IUser userServiceDelegate;

	@RequestMapping(value = "/register", produces = { "application/json" }, method = RequestMethod.POST)
	public String register(@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "telNum", required = true) String telNum) {
		return userServiceDelegate.register(user, telNum);
	}

	@RequestMapping(value = "/modifyuser", produces = { "application/json" }, method = RequestMethod.PUT)
	public int modifyUser(@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "telNum", required = true) String telNum) {
		return userServiceDelegate.modifyUser(user, telNum);
	}

	@RequestMapping(value = "/addfocus", produces = { "application/json" }, method = RequestMethod.POST)
	public int addFocus(@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "city", required = true) String city) {
		return userServiceDelegate.addFocus(user, city);
	}

	@RequestMapping(value = "/delfocus", produces = { "application/json" }, method = RequestMethod.PUT)
	public int delFocus(@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "city", required = true) String city) {
		return userServiceDelegate.delFocus(user, city);
	}

	@RequestMapping(value = "/getfocus", produces = { "application/json" }, method = RequestMethod.GET)
	public String[] getFocus(@RequestParam(value = "user", required = true) String user) {
		return userServiceDelegate.getFocus(user);
	}

}
