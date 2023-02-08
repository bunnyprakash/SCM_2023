package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.SignupRepository;
import com.example.demo.model.Signup;

@Service
public class UserService  {
	
		@Autowired
		private SignupRepository signupRepository;
		
		@Autowired
		private PasswordEncoder passwordEncoder;
		
		public String register(Signup user) {
			boolean flag = isExist(user.getEmail());
			if(flag) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				user.setRole("ROLE_"+user.getRole());
				user.setEnabled(true);
				signupRepository.save(user);
				return user.getEmail()+" Registered Succesfully";
			}
			return "User "+user.getEmail() +" Already Exists !!!";
		}

		private boolean isExist(String email) {
			Signup user = signupRepository.findByEmail(email);
			if(user != null) {
				return false;
			}
			return true;
		}

}
