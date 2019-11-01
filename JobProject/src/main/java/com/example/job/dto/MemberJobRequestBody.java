package com.example.job.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberJobRequestBody {

	@JsonProperty("customerId")
	public String customerId;

	@JsonProperty("name")
	public String name;

	@JsonProperty("addr")
	public String addr;

	@JsonProperty("age")
	public String age;

	@JsonProperty("tel")
	public String tel;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "CustomerRequestBody [customerId=" + customerId + ", name=" + name + ", addr=" + addr + ", age=" + age
				+ ", tel=" + tel + "]";
	}

}
