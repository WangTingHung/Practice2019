package com.example.job.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.job.entity.Job;
import com.example.job.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=true)
	public Job finJobBySeq(Integer seq) {
		logger.info("#####   finJobBySeq(seq:"+seq+" )   #####");
		return em.find(Job.class, seq);
	}

}
