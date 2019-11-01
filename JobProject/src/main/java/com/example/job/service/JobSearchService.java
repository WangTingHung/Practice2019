package com.example.job.service;

import java.util.List;

import com.example.job.dto.JobDTO;
import com.example.job.dto.JobSearchCondiction;
import com.example.job.dto.PageBean;



public interface JobSearchService {

	/**
	 * @author Danny
	 * @param 
	 * @return return_type
	 * @see com.example.job.service#method()
	 * @date 2019年9月29日
	 */
	public List<JobDTO> getAllJob();
	
	/**
	 * @author Tillie Hung
	 * @param JobSearchCondiction condiction
	 * @return List<JobDTO>
	 * @see com.example.job.service.impl.JobSearchServiceImpl#getJobList(JobSearchCondiction condiction)
	 * @date 2019年9月29日
	 */
	public PageBean<JobDTO> getJobList(JobSearchCondiction condiction);
	
}
