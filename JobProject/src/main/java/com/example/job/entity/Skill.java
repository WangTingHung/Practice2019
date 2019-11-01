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
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.example.job.enums.Status;

@Entity
@Table(name = "skill")
@Access(AccessType.FIELD)
public class Skill implements Serializable {
	
	private static final long serialVersionUID = 3151824504972602727L;

	/*********************** 
	 * Database Field
	 ***********************/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seq")
	private Integer seq;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "status")
	private Status status;
	
	/****************************************
	 * DB Relationship
	 ****************************************/
	@ManyToOne()
	@JoinColumn(name="parent_seq")
	private Skill skill;
	
	/****************************************
	 * Other function
	 ****************************************/
	@PrePersist
	public void insertDefault() {
		this.status = Status.ENABLED;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	
	
}
