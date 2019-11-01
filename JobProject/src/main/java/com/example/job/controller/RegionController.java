package com.example.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.dto.AsyncResponse;
import com.example.job.dto.AsyncResponse.HttpStatus;
import com.example.job.dto.RegionDTO;
import com.example.job.service.RegionService;

@CrossOrigin("*")
@RestController
public class RegionController {
	
	@Autowired
	public RegionService regionService;
	
	
	@GetMapping(value="/getRegion")
	public AsyncResponse getAllRegion(){
		
		AsyncResponse response = new AsyncResponse();
		response.setData(regionService.getTaipeiAllDist());
		response.setStatus(HttpStatus.SUCCESS);
		return response;
	}
	
	@GetMapping(value="regions")
	public List<RegionDTO> getRegions() {
		return regionService.getTaipeiAllDist();
	}

}
