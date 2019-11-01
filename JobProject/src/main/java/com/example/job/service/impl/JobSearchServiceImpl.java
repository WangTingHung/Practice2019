package com.example.job.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.job.dto.JobDTO;
import com.example.job.dto.JobSearchCondiction;
import com.example.job.dto.PageBean;
import com.example.job.entity.Job;
import com.example.job.service.JobSearchService;

import ch.qos.logback.core.joran.conditional.Condition;


@Service
public class JobSearchServiceImpl implements JobSearchService {

	private static final Logger logger = LoggerFactory.getLogger(JobSearchServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<JobDTO> getAllJob() {
		logger.info("#####   getAllJob()   #####");
		List<Job> job = new ArrayList<Job>();
		
		String sql = "SELECT NEW com.example.job.dto.JobDTO(j.seq, j.job,"
						+ " j.company,j.experience,j.salaryHigh, "
						+ "j.salaryLow, j.region,"
						+ " j.url)"+
					 " FROM Job job" + 
					 "LEFT JOIN job.seq job_skill" +
					 "LEFT JOIN job_skill skill" +
					 "LEFT JOIN job.company company" + 
					 "LEFT JOIN job.region region" + 
					 "LEFT JOIN jobCategorys jobCategory" + 
					 "LEFT JOIN jobCategory.category category" + 
					 "LEFT JOIN category.category parentCategory" + 
					 "WHERE 1=1" + 
					 "AND skill.name in :skill" + 
					 "AND category.seq in :categoryList" + 
					 "AND j.company in :company" + 
					 "AND j.salaryHigh in :moneyHigh" + 
					 "AND j.salaryLow in :moneyLow" + 
					 "AND j.region.seq in :regionList" + 
					 "AND j.experience in :year" + 
					 "GROUP BY job.seq";
	///////////////////////////////////////////////
		List<JobDTO> list= new ArrayList<JobDTO>();
		
		list = em.createQuery(sql,JobDTO.class)
				.setParameter("skill", list)
				.setParameter("categoryList",list )
				.setParameter("company", list)
				.setParameter("salaryHigh", list)
				.setParameter("salaryLow", list)
				.setParameter("regionList", list)
				.setParameter("year", list).getResultList();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public PageBean<JobDTO> getJobList(JobSearchCondiction condiction) {
		logger.info("#####   getJobList("+condiction+")  #####");
		
		PageBean<JobDTO> pageBean = new PageBean<JobDTO>();
		String sql_count = " SELECT COUNT(DISTINCT job.seq ) ";
		String sql_select = "SELECT DISTINCT NEW com.example.job.dto.JobDTO(job.seq, job.name,company.name,job.experience,job.salaryHeight,job.salaryLow,region.name ,job.jobUrl)";
		StringBuffer sql = new StringBuffer();
		sql.append(" FROM Job job ");
		sql.append(" LEFT JOIN job.jobSkills jobSkill");
		sql.append(" LEFT JOIN jobSkill.skill skill");
		sql.append(" LEFT JOIN job.jobCategorys jobCategory");
		sql.append(" LEFT JOIN job.company company ");
		sql.append(" LEFT JOIN job.region region ");
		sql.append(" WHERE 1=1 ");
		
		if(condiction.getSkills().size()!=0) {
			sql.append(" AND skill.seq IN :skills ");
		}
		if(condiction.getCategorys().size()!=0) {
			sql.append(" AND jobCategory.category.seq IN :categorys ");
		}
		if(condiction.getMoneyHigh()!=0 || condiction.getMoneyLow()!=0) {
			if(condiction.getMoneyHigh()!=0 && condiction.getMoneyLow()!=0 ) { //有最高值 &最低值
				sql.append(" AND ( job.salaryHeight <= :moneyHigh AND job.salaryLow >= :moneyLow )");
			}
			if(condiction.getMoneyHigh()!=0 && condiction.getMoneyLow()==0 ) {//有最高值
				sql.append(" AND job.salaryHeight <= :moneyHigh ");
			}
			if(condiction.getMoneyHigh()==0 && condiction.getMoneyLow()!=0 ) { //有最低值
				sql.append(" AND job.salaryLow >= :moneyLow ");
			}
		}
		if(condiction.getRegion()!=0) {
			sql.append(" AND job.region.seq = :region ");
		}
		if(condiction.getYear()!=99) { //99為沒選擇, 0為不拘
			sql.append(" AND job.experience = :year ");
		}
		if (condiction.getSortColumn() != null && condiction.getSortColumn().trim().length() != 0) {
			sql.append(" ORDER BY ");
			if("job.salary".equals(condiction.getSortColumn())) {
				sql.append(condiction.getIsAsc() ? "job.salaryLow ASC " : " job.salaryHeight DESC ");
				
			}else {
				sql.append(condiction.getSortColumn() + " ") ;
				sql.append(condiction.getIsAsc() ? " ASC " : " DESC ");
			}
		}
		
		
		logger.info("count"+sql_count+sql.toString());
		logger.info("select"+sql_select+sql.toString());
		TypedQuery<Long> queryCount = em.createQuery(sql_count+sql.toString(),Long.class);
		TypedQuery<JobDTO> query = em.createQuery(sql_select+sql.toString(),JobDTO.class);
		if(condiction.getSkills().size()!=0) {
			queryCount.setParameter("skills", condiction.getSkills());
			query.setParameter("skills", condiction.getSkills());
		}
		if(condiction.getCategorys().size()!=0) {
			queryCount.setParameter("categorys", condiction.getCategorys());
			query.setParameter("categorys", condiction.getCategorys());
		}
		if(condiction.getMoneyHigh()!=0 || condiction.getMoneyLow()!=0) {
			if(condiction.getMoneyHigh()!=0 && condiction.getMoneyLow()!=0 ) { //有最高值 &最低值
				queryCount.setParameter("moneyHigh", condiction.getMoneyHigh());
				queryCount.setParameter("moneyLow", condiction.getMoneyLow());
				query.setParameter("moneyHigh", condiction.getMoneyHigh());
				query.setParameter("moneyLow", condiction.getMoneyLow());
			}
			if(condiction.getMoneyHigh()!=0 && condiction.getMoneyLow()==0 ) {//有最高值
				queryCount.setParameter("moneyHigh", condiction.getMoneyHigh());
				query.setParameter("moneyHigh", condiction.getMoneyHigh());
			}
			if(condiction.getMoneyHigh()==0 && condiction.getMoneyLow()!=0 ) { //有最低值
				queryCount.setParameter("moneyLow", condiction.getMoneyLow());
				query.setParameter("moneyLow", condiction.getMoneyLow());
			}
		}
		if(condiction.getRegion()!=0) {
			queryCount.setParameter("region", condiction.getRegion());
			query.setParameter("region", condiction.getRegion());
		}
		if(condiction.getYear()!=99) { //99為沒選擇, 0為不拘
			queryCount.setParameter("year", condiction.getYear());
			query.setParameter("year", condiction.getYear());
		}

		Integer dbCount = queryCount.getSingleResult().intValue();
		
		pageBean.setPageSize(20);
		pageBean.setPageNo(condiction.getPageNo());
		pageBean.setDbCount(dbCount);
		
		List<JobDTO> jobs = query.setFirstResult(pageBean.getStartRow()).setMaxResults(pageBean.getPageSize()).getResultList();
		pageBean.setResultList(jobs);
		return pageBean;
	}

}
