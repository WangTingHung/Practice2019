package com.example.job.dto;

import java.io.Serializable;

public class JobDTO implements Serializable {
	
/**
 * @author Danny
 * @param 
 * @return return_type
 * @see com.example.job.dto#method()
 * @date 2019年9月29日
 */
	private static final long serialVersionUID = -9002983774550428273L;

	private Integer seq;
	
	private String job;
	
	private String company;
	
	private Integer experience;
	
	private Integer salaryHigh;
	
	private Integer salaryLow;
	
	private String region;
	
	private String url;

	
	
	public JobDTO() {
		super();
	}

	public JobDTO(Integer seq, String job,String company,Integer experience,Integer salaryHigh,Integer salaryLow,String region,String url) {
		super();
		this.seq = seq;
		
		this.job = job;
		
		this.company = company;

		this.experience = experience;
		
		this.salaryHigh = salaryHigh;
		
		this.salaryLow = salaryLow;
		
		this.region = region;
		
		this.url = url;
		
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getSalaryHigh() {
		return salaryHigh;
	}

	public void setSalaryHigh(Integer salaryHigh) {
		this.salaryHigh = salaryHigh;
	}

	public Integer getSalaryLow() {
		return salaryLow;
	}

	public void setSalaryLow(Integer salaryLow) {
		this.salaryLow = salaryLow;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	}

	

