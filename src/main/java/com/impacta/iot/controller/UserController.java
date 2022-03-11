package com.impacta.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impacta.iot.service.UserService;
import com.impacta.iot.vo.UserRequestVO;
import com.impacta.iot.vo.UserResponseVO;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/{id}")
	public UserResponseVO findLoginById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public UserResponseVO saveLogin(@RequestBody UserRequestVO request) {
		return service.save(request);
	}
}