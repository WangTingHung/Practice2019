package com.example.job.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.dto.AsyncResponse;
import com.example.job.dto.AsyncResponse.HttpStatus;
import com.example.job.dto.JobSearchCondiction;
import com.example.job.service.JobSearchService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class JobSearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(JobSearchController.class);


	@Autowired
	public JobSearchService jobSearchService;
	
	/**
	 * @author Danny
	 * @param 
	 * @return return_type
	 * @see com.example.job.controller#method()
	 * @date 2019年9月26日
	 */
	@GetMapping(value="/getJob")
	public AsyncResponse getAllJob(){
		
		AsyncResponse response = new AsyncResponse();
		response.setData(jobSearchService.getAllJob());
		response.setStatus(HttpStatus.SUCCESS);
		return response;
	}
	
	@PostMapping(value="/job/jobs")
	public AsyncResponse getJobList(@RequestBody JsonNode jsonObject,HttpServletRequest request,HttpSession session) {
		logger.info("#####   WebRequest - "+request.getRequestURI()+" ,method: "+request.getMethod()+",Param: "+jsonObject +"  #####");
		AsyncResponse response = new AsyncResponse();
		JobSearchCondiction condiction = new JobSearchCondiction();
		
		try {
			//取得skill參數
			List<Integer> skills = new ArrayList<Integer>();
			for(JsonNode skill : jsonObject.get("skills")) {
				skills.add(skill.asInt());
			}
			condiction.setSkills(skills);
			
			//取得category參數
			List<Integer> categorys = new ArrayList<Integer>();
			for(JsonNode category : jsonObject.get("categorys")) {
				categorys.add(category.asInt());
			}
			condiction.setCategorys(categorys);
			
			//取得薪水參數
			condiction.setMoneyHigh(jsonObject.get("moneyHigh").asInt());
			condiction.setMoneyLow(jsonObject.get("moneyLow").asInt());
			
			//取得地區 & 年資
			condiction.setRegion(jsonObject.get("region").asInt());
			condiction.setYear(jsonObject.get("year").asInt());
			condiction.setPageNo(jsonObject.get("pageNo").asInt());
			condiction.setSortColumn(jsonObject.get("sortColumn").asText());
			condiction.setIsAsc(jsonObject.get("isAsc").asBoolean());
			response.setData(jobSearchService.getJobList(condiction));
			response.setMessage((String)session.getAttribute("memberName"));
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Exception - "+e.getMessage());
			response.setStatus(HttpStatus.FAILED);
			response.setMessage(e.getMessage());
		}

		
		
		
		return response;
	}
}
