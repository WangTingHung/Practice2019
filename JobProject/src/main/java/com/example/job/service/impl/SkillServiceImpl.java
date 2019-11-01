package com.example.job.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.job.dto.JsonMapObj;
import com.example.job.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	private static final Logger logger = LoggerFactory.getLogger(SkillServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<JsonMapObj> getAllSkill(String searchText) {
		logger.info("#####   getAllSkill(searchText:"+searchText+")   #####");
		List<JsonMapObj> list = em.createQuery(" SELECT NEW com.example.job.dto.JsonMapObj(skill.seq,skill.name) FROM Skill skill WHERE skill.name LIKE :searchText ",JsonMapObj.class)
							 .setParameter("searchText", "%"+searchText+"%")
							 .setMaxResults(10).getResultList();
		return list;
	}
	
	
	
}
