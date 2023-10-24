package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

@Controller
//@RequestMapping("상위 공통 주소")
public class UesrController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("selectUser")
	public String selectUser(String userId, Model model) {
		
		User user = service.selectUser(userId);
		
		if(user == null) return "searchFail";
		
		model.addAttribute("user", user);
		return "searchSuccess";
	}
	
	
	
	
	
}
