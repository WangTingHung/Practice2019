package com.example.job.dto;

import java.util.List;

import com.example.job.entity.MemberJob;

public class MemberJobResponseBody {

	private String returnCode;

	private List<MemberJob> dataList;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public List<MemberJob> getDataList() {
		return dataList;
	}

	public void setDataList(List<MemberJob> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "MemberJobResponseBody [returnCode=" + returnCode + ", dataList=" + dataList + "]";
	}

}
