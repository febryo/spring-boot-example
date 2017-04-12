package com.febryo.oracle.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.febryo.oracle.model.Customer;
import com.febryo.oracle.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/getByCode", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ApiOperation(notes = "get customer by code", value = "get customer by code")
	public @ResponseBody Customer findByEmail(@RequestParam String email) {
		return customerService.findByCode(email);
	}

	@RequestMapping(value = "/generateBigData", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ApiOperation(notes = "generate customer by totalData", value = "generate customer by totalData")
	public @ResponseBody Map<String, Object> generateBigData(@RequestParam int totalData) {
		Map<String, Object> map = new HashMap<>();

		String error = "";
		customerService.createBigData(totalData);

		map.put("success", true);
		map.put("error", error);
		return map;
	}

}
