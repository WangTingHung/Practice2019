package com.example.job.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.job.entity.Category;
import com.example.job.enums.Status;
import com.example.job.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<Category> getParentCategory() {
		logger.info("#####   getParentCategory()   #####");
		return em.createQuery(" FROM Category c WHERE c.category IS null AND c.status = :status",Category.class).setParameter("status", Status.ENABLED).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Category> getCategoryByParent(Integer parentSeq) {
		logger.info("#####   getCategoryByParent(parentSeq : "+parentSeq+" )   #####");
		String sql = " FROM Category c WHERE c.category.seq = :parentSeq AND c.status = :status";
		return em.createQuery(sql,Category.class).setParameter("parentSeq", parentSeq).setParameter("status", Status.ENABLED).getResultList();
	}

}
