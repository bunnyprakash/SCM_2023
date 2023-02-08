package com.example.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
	
	@GetMapping("/")
	public String dashboard(Model model,Principal principal) {
		model.addAttribute("username",principal.getName());
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/register")
	public String signup(Model model) {
		return "signup";
	}
	   
	@GetMapping("/loginerror")
	public String loginerror(Model model) {
    	model.addAttribute("message","Bad Credentials");
    	return "login";
    }
	
	@RequestMapping("/create")
	public String createShipment(Model model, @RequestParam(value = "success" , required = false) String success, @RequestParam(value = "error", required = false) String error) {
		if(success != null) {
			model.addAttribute("success",success);
		}
		else {
			model.addAttribute("error",error);
		}
    	return "createshipment";
    }
	
	@GetMapping("/signerror")
	public String signerror(Model model) {
		model.addAttribute("message1","user alredy exists!!!!!!!!!!!!");
    	return "newsignup";
    }
	   
	@GetMapping("/forgotpassword")
    public String forgotpassword(Model model) {
        return "forgotpassword";
    }
	
}
