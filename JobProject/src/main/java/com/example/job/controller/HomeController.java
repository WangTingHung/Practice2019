package com.example.job.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.job.service.CategoryService;
import com.example.job.service.RegionService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	public RegionService regionService;
	
	@Autowired
	public CategoryService categoryService;

	@GetMapping("/")
	public String home(Model model,HttpSession session) {
		logger.info("#####  Welcome To Home  #####");
		model.addAttribute("regions",regionService.getTaipeiAllDist());
		model.addAttribute("categorys",categoryService.getParentCategory());
		return "index";
	}
}
