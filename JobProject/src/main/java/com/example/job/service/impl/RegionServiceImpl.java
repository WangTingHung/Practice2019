package com.example.job.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.job.dto.RegionDTO;
import com.example.job.enums.RegionType;
import com.example.job.enums.Status;
import com.example.job.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

	private static final Logger logger = LoggerFactory.getLogger(RegionServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<RegionDTO> getTaipeiAllDist() {
		logger.info("#####   getTaipeiAllDist()   #####");
		List<Integer> taipei = new ArrayList<Integer>();
		taipei.add(22);//台北市
		taipei.add(23);//新北市
		String sql = "SELECT NEW com.example.job.dto.RegionDTO(r.seq, r.name)"+
					 " FROM Region r WHERE r.status = :status "+
					 " AND r.regionType = :regionType "+
					 " AND r.region.seq IN :taipei ";
		List<RegionDTO> list = em.createQuery(sql,RegionDTO.class)
				.setParameter("status", Status.ENABLED)
				.setParameter("regionType", RegionType.DISTRICT)
				.setParameter("taipei", taipei).getResultList();
		return list;
	}

}
