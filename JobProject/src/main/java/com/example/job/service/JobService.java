package com.example.job.service;

import com.example.job.entity.Job;

public interface JobService {
	
	/**
	 * @author Tillie Hung
	 * @param Integer seq
	 * @return Job
	 * @see com.example.job.service.impl.JobServiceImpl#finJobBySeq(Integer seq)
	 * @date 2019年9月29日
	 */
	public Job finJobBySeq(Integer seq);

}
