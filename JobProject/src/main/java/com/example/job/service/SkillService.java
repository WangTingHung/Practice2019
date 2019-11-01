package com.example.job.service;

import java.util.List;

import com.example.job.dto.JsonMapObj;

public interface SkillService {
	
	/**
	 * @author Tillie Hung
	 * @param String searchText
	 * @return List<Skill>
	 * @see com.example.job.service.SkillService#getAllSkill()
	 * @date 2019年9月27日
	 */
	public List<JsonMapObj> getAllSkill(String searchText);

}
