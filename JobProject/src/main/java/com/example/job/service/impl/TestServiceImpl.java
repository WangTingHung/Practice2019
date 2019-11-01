package com.example.job.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.job.dto.TestProjectListDTO;
import com.example.job.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<TestProjectListDTO> getAllTestProjectList() {
		logger.info("getAllTestProjectList()");
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT NEW com.example.job.dto.TestProjectListDTO(t.seq, t.groupName, t.customerName, t.customerId, t.msr,t.rorwa,t.raroc, t.lastYear, t.thisYear,t.storeAmount,t.releaseAmount, t.tradeBalance )");
		sql.append(" FROM TestProjectList t ");
		List<TestProjectListDTO> list = em.createQuery(sql.toString(),TestProjectListDTO.class).getResultList();
		for(TestProjectListDTO i : list) {
			List<Integer> icons = em.createQuery(" SELECT i.iconId FROM TestProjectIcon i WHERE i.customerId = :id ",Integer.class).setParameter("id", i.getSeq()).getResultList();
			i.setIcons(icons);
		}
		return list;
	}

}
