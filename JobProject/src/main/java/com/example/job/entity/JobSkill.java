package com.example.job.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_skill")
@Access(AccessType.FIELD)
public class JobSkill implements Serializable {

	private static final long serialVersionUID = -7651300206111130013L;

	/*********************** 
	 * Database Field
	 ***********************/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seq")
	private Integer seq;
	
	/****************************************
	 * DB Relationship
	 ****************************************/
	
	@ManyToOne()
	@JoinColumn(name="job_seq")
	private Job job;
	
	@ManyToOne()
	@JoinColumn(name="skill_seq")
	private Skill skill;

	
	/****************************************
	 * Other function
	 ****************************************/
	
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	
}
