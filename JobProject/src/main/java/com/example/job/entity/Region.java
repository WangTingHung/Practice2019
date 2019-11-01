package com.example.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.example.job.enums.RegionType;
import com.example.job.enums.Status;

@Entity
@Table(name = "region")
//@Access(AccessType.FIELD)
public class Region implements java.io.Serializable {
	
	private static final long serialVersionUID = -2752585272465566759L;

	/*********************** 
	 * Database Field
	 ***********************/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seq")
	private Integer seq;
	
	@Column(name = "region_type")
	private RegionType regionType;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "area_code")
	private String areaCode;
	
	@Column(name = "status")
	private Status status;
	
	/****************************************
	 * DB Relationship
	 ****************************************/
	
	@ManyToOne()
	@JoinColumn(name="parent_seq")
	private Region region;

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

	public RegionType getRegionType() {
		return regionType;
	}

	public void setRegionType(RegionType regionType) {
		this.regionType = regionType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
}