package com.example.job.service;

import java.util.List;

import com.example.job.dto.RegionDTO;

public interface RegionService {
	
	/**
	 * @author WanTing
	 * @param n/a
	 * @return List<Region>
	 * @see com.example.job.servic.RegionServiceImpple#getTaipeiAllDist()
	 * @date 2019年9月19日
	 */
	public List<RegionDTO> getTaipeiAllDist();

}
