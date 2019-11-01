package com.example.job.dto;

import java.io.Serializable;

public class RegionDTO implements Serializable {
	

	private static final long serialVersionUID = -9002983774550428273L;

	private Integer seq;
	
	private String name;

	
	
	public RegionDTO() {
		super();
	}

	public RegionDTO(Integer seq, String name) {
		super();
		this.seq = seq;
		this.name = name;
	}

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

	
	
}
