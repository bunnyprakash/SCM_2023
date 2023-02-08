package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.SignupRepository;
import com.example.demo.model.Signup;
import com.example.demo.service.UserService;

@RestController
public class SignupController {

	@Autowired
	public SignupRepository signupRepository;
	
	@Autowired
	private UserService userService;
	
//	@GetMapping(value = "/listofusers")
//	public List<Signup> newsignuplist(){
//		return signupRepository.findAll();
//	}

	@PostMapping(value = "/register")
	public String createuser(@RequestBody Signup signup){
			return userService.register(signup);
	}
	
}
