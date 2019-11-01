package com.example.job.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.dto.AsyncResponse;
import com.example.job.service.SkillService;

@RestController
@RequestMapping("skill")
public class SkillController {
	
	private static final Logger logger = LoggerFactory.getLogger(SkillController.class);
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping(value="/searchSkills")
	public AsyncResponse searchSkills(@RequestParam(name="searchText") String searchText, HttpServletRequest request) {
		logger.info("#####   WebRequest - "+request.getRequestURI()+" ,method: "+request.getMethod()+",Param: "+searchText +"  #####");
		AsyncResponse response = new AsyncResponse();
		response.setData(skillService.getAllSkill(searchText));
		return response;
	}
	

}
