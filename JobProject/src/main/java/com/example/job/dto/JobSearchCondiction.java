package com.example.job.dto;

import java.io.Serializable;
import java.util.List;

public class JobSearchCondiction implements Serializable {

	private static final long serialVersionUID = -1247151084795638526L;
	
	private List<Integer> skills;
	
	private List<Integer> categorys;
	
	private Integer moneyHigh;
	
	private Integer moneyLow;
	
	private Integer region;
	
	private Integer year;
	
	private Integer pageNo;
	
	private String sortColumn;
	
	private Boolean isAsc;

	public List<Integer> getSkills() {
		return skills;
	}

	public void setSkills(List<Integer> skills) {
		this.skills = skills;
	}

	public List<Integer> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Integer> categorys) {
		this.categorys = categorys;
	}

	public Integer getMoneyHigh() {
		return moneyHigh;
	}

	public void setMoneyHigh(Integer moneyHigh) {
		this.moneyHigh = moneyHigh;
	}

	public Integer getMoneyLow() {
		return moneyLow;
	}

	public void setMoneyLow(Integer moneyLow) {
		this.moneyLow = moneyLow;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public Boolean getIsAsc() {
		return isAsc;
	}

	public void setIsAsc(Boolean isAsc) {
		this.isAsc = isAsc;
	}

	@Override
	public String toString() {
		return "JobSearchCondiction [skills=" + skills + ", categorys=" + categorys + ", moneyHigh=" + moneyHigh
				+ ", moneyLow=" + moneyLow + ", region=" + region + ", year=" + year + ", pageNo=" + pageNo
				+ ", sortColumn=" + sortColumn + ", isAsc=" + isAsc + "]";
	}

}
