package com.impacta.iot.controller;

import java.util.List;

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
	
	@GetMapping
	public List<UserResponseVO> findAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public UserResponseVO findUserById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public UserResponseVO saveUser(@RequestBody UserRequestVO request) {
		return service.save(request);
	}
}