package com.example.job.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.example.job.enums.Status;

@Entity
@Table(name = "company")
@Access(AccessType.FIELD)
public class Company implements Serializable{

	private static final long serialVersionUID = 8505778894439104237L;

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
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;
	
	/****************************************
	 * DB Relationship
	 ****************************************/
	@ManyToOne()
	@JoinColumn(name="region_seq")
	private Region region;
	
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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	

}
