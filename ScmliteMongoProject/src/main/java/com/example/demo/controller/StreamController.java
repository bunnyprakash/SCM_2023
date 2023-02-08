package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Repository.StreamRepository;
@Controller
public class StreamController {

	@Autowired
	StreamRepository streamRepository;
	
	@RequestMapping("/device")
	public String home(Model model) {
		System.out.println(model.addAttribute("DeviceData", streamRepository.findAll()));
		return "Stream";
	}
	
}
