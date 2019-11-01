package com.example.job.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberJobResponse {

	@JsonProperty("header")
	public CommonHeader header;

	@JsonProperty("body")
	public MemberJobResponseBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public MemberJobResponseBody getBody() {
		return body;
	}

	public void setBody(MemberJobResponseBody body) {
		this.body = body;
	}


	@Override
	public String toString() {
		return "MemberJobResponse [header=" + header + ", body=" + body + "]";
	}
}
