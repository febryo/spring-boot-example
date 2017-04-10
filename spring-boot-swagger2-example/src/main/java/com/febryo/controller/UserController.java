package com.febryo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.febryo.model.UserModel;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@RequestMapping(value = "/list", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ApiOperation(notes = "to get list of user", value = "get list of user by name")
	public @ResponseBody UserModel getList(@RequestParam String name) {
		UserModel userModel = new UserModel("1234", name, "test@mailinator.com");
		return userModel;
	}

}
