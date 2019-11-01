package com.example.job.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.dto.TestProjectListDTO;
import com.example.job.entity.TestProjectList;
import com.example.job.service.TestService;

@CrossOrigin("*")
@RestController
@RequestMapping("test")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	@GetMapping(value="/loginAccount")
	public Map<String,Object> loginAccount(HttpServletRequest request,@RequestParam(value="visitTimes")Integer count){
		logger.info("#####   WebRequest - "+request.getRequestURI()+" ,method: "+request.getMethod()+"  count : "+count+"#####");
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("id", "NT81752-t");
		result.put("dep", "企金企劃部-t");
		result.put("office", "營運管理科-t");
		result.put("name", "葉又萱-t");
		return result;
	}
	
	@GetMapping(value="/getAllCustomer")
	public List<TestProjectListDTO> getAllTestProjectList(HttpServletRequest request){
		logger.info("#####   WebRequest - "+request.getRequestURI()+" ,method: "+request.getMethod()+"#####");
		return testService.getAllTestProjectList();
	}
	

}
