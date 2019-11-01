package com.example.job.service;

import java.util.List;

import com.example.job.entity.Category;

public interface CategoryService {
	
	/**
	 * @author Tillie Hung
	 * @param n/a
	 * @return List<Category>
	 * @see com.example.job.service.CategoryServiceImpl#getParentCategory()
	 * @date 2019年9月28日
	 */
	public List<Category> getParentCategory();
	
	/**
	 * @author Tillie Hung
	 * @param Integer parentSeq
	 * @return List<Category>
	 * @see com.example.job.service#getCategoryByParent(Integer parentSeq)
	 * @date 2019年9月28日
	 */
	public List<Category> getCategoryByParent(Integer parentSeq);

}
