package com.iot.impacta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iot.impacta.service.AppService;
import com.iot.impacta.vo.LoginRequestVO;
import com.iot.impacta.vo.LoginResponseVO;

@RestController
@RequestMapping("/app")
public class AppController {
	
	@Autowired
	private AppService service;
	
	@GetMapping("/teste")
	public String teste() {
		return "Hello World";
	}
	
	@GetMapping("/login/{id}")
	public LoginResponseVO findLoginById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/login/")
	public LoginResponseVO saveLogin(@RequestBody LoginRequestVO request) {
		return service.save(request);
	}
}