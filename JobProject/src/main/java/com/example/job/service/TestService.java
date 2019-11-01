package com.example.job.service;

import java.util.List;

import com.example.job.dto.TestProjectListDTO;
import com.example.job.entity.TestProjectList;

public interface TestService {
	
	List<TestProjectListDTO> getAllTestProjectList();

}
