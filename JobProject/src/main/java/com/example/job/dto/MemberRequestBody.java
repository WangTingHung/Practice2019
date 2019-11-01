package com.example.job.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberRequestBody {

	@JsonProperty("seq")
	public Integer seq;
	
	@JsonProperty("name")
	public String name;
	
	@JsonProperty("phone")
	public String phone;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
