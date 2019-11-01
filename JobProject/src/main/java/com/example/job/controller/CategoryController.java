package com.example.job.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.dto.AsyncResponse;
import com.example.job.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value="/getCategoryByParent/{parentSeq}")
	public AsyncResponse getAllRegion(HttpServletRequest request,@PathVariable Integer parentSeq){
		logger.info("#####   WebRequest - "+request.getRequestURI()+" ,method: "+request.getMethod()+"  #####");

		AsyncResponse response = new AsyncResponse();
		response.setData(categoryService.getCategoryByParent(parentSeq));
		return response;
	}
}
