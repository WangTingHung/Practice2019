package com.example.job.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.example.job.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
@Table(name = "job")
@Access(AccessType.FIELD)
public class Job implements Serializable  {
	
	private static final long serialVersionUID = 4270236793223982555L;

	/*********************** 
	 * Database Field
	 ***********************/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seq")
	private Integer seq;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "job_date")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private LocalDateTime endDate;
	
	@Column(name="address")
	private String address;
	
	@Column(name = "salary_height")
	private Integer salaryHeight;
	
	@Column(name = "salary_low")
	private Integer salaryLow;
	
	@Column(name="job_url")
	private String jobUrl;
	
	@Column(name = "experience")
	private Integer experience;
	
	@Column(name = "status")
	private Status status;
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;
	
	/****************************************
	 * DB Relationship
	 ****************************************/
	@ManyToOne()
	@JoinColumn(name="company_seq")
	private Company company;
	
	@ManyToOne()
	@JoinColumn(name="region_seq")
	private Region region;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "job",fetch=FetchType.LAZY)
	private List<JobCategory> jobCategorys;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "job",fetch=FetchType.LAZY)
	private List<JobSkill> jobSkills;
	
	/****************************************
	 * Other function
	 ****************************************/
	
	@PreUpdate
	public void updateupdatedate() {
		this.updateDate = LocalDateTime.now();
	}
	
	@PrePersist
	public void insertDefault() {
		this.status = Status.ENABLED;
		this.updateDate = LocalDateTime.now();
	}

	/****************************************
	 * Other field
	 ****************************************/
	
	/***********************
	 * Getter and Setter
	 ***********************/
	
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSalaryHeight() {
		return salaryHeight;
	}

	public void setSalaryHeight(Integer salaryHeight) {
		this.salaryHeight = salaryHeight;
	}

	public Integer getSalaryLow() {
		return salaryLow;
	}

	public void setSalaryLow(Integer salaryLow) {
		this.salaryLow = salaryLow;
	}

	public String getJobUrl() {
		return jobUrl;
	}

	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	
}
