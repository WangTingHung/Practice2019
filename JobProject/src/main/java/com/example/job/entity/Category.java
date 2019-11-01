package com.example.job.entity;

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
@Table(name = "category")
@Access(AccessType.FIELD)
public class Category  implements java.io.Serializable {
	
	private static final long serialVersionUID = 4839898840152382244L;

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
	private Category category;
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
