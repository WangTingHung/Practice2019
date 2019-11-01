package com.example.job.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonHeader {

	@JsonProperty("seq")
	public Integer seq;
	
	@JsonProperty("name")
	public String name;
	
	@JsonProperty("phone")
	public String phone;
	
	@JsonProperty("member_seq")
	public Integer member_seq;
	
	@JsonProperty("job_seq")
	public Integer job_seq;

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

	public Integer getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(Integer member_seq) {
		this.member_seq = member_seq;
	}

	public Integer getJob_seq() {
		return job_seq;
	}

	public void setJob_seq(Integer job_seq) {
		this.job_seq = job_seq;
	}

	
	
	
	
}
