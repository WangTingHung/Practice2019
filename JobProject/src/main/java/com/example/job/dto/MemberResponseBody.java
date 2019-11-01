package com.example.job.dto;

import java.util.List;

import com.example.job.entity.Member;



public class MemberResponseBody {

	private String returnCode;

	private List<Member> dataList;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public List<Member> getDataList() {
		return dataList;
	}

	public void setDataList(List<Member> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "CustomerResponseBody [returnCode=" + returnCode + ", dataList=" + dataList + "]";
	}

}
