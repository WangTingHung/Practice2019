package com.example.job.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.job.entity.MemberJob;
import com.example.job.respository.MemberJobRespository;
import com.example.job.respository.MemberRespository;
import com.example.job.service.MemberJobService;


@Service
public class MemberJobServiceImpl implements MemberJobService {

	private static final Logger logger = LoggerFactory.getLogger(MemberJobServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	public MemberJobRespository memberJobRespository;
	
	@Autowired
	public MemberRespository memberRespository;
	
	@Autowired
	public JobServiceImpl jobServiceImpl;

	@Override
	public MemberJob findBySeq(Integer seq) {
		Optional<MemberJob> customerOpt = memberJobRespository.findById(seq);
		return customerOpt.orElse(new MemberJob());
	}

	@Override
	public void save(MemberJob memberJob) {
		
		memberJobRespository.save(memberJob);
		
	}

	@Override
	public void delete(Integer seq) {
		memberJobRespository.deleteById(seq);
		
	}

	@Override
	public List<MemberJob> findByJobId(MemberJob memberJob) {
		return memberJobRespository.findByJobId(
				memberJob.getSeq(), memberJob.getMemberSeq(), memberJob.getJobSeq());
	}

	@Override
	public List<MemberJob> findAll() {
		return memberJobRespository.findAll();
	}

	@Override
	@Transactional
	public void addToFavorite(String action, Integer jobSeq, Integer memSeq) {
		logger.info("#####   addToFavorite(action:"+action+", jobSeq:"+jobSeq+" ,memSeq:"+memSeq+" )   #####");

		if("on".equals(action)) { //新增
			MemberJob memberJob = new MemberJob();
			memberJob.setJobSeq(jobSeq);
			memberJob.setMemberSeq(memSeq);
			this.save(memberJob);
		}else { //刪除
//			List<MemberJob> jobs = findByJobId(memberJob);
			List<MemberJob> jobs = this.getMemberJobByMemberAndJob(memSeq, jobSeq);
			for(MemberJob job : jobs) {
				this.delete(job.getSeq());
			}
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<MemberJob> getMemberJobByMemberAndJob(Integer memSeq, Integer jobSeq) {
		logger.info("#####   getMemberJobByMemberAndJob(memSeq:"+memSeq+", jobSeq:"+jobSeq+" )   #####");
		return em.createQuery("FROM MemberJob m WHERE m.memberSeq = :memSeq AND m.jobSeq = :jobSeq ",MemberJob.class)
				.setParameter("memSeq", memSeq)
				.setParameter("jobSeq", jobSeq)
				.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Integer> getJobSeqByMember(Integer memSeq) {
		logger.info("#####   getJobSeqByMember(memSeq:"+memSeq+" )   #####");
		return em.createQuery("SELECT mj.jobSeq FROM MemberJob mj WHERE mj.memberSeq = :memSeq ",Integer.class).setParameter("memSeq", memSeq).getResultList();
	}

}
