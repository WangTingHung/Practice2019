package com.example.job.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberRequest {
	
	@JsonProperty("header")
	public CommonHeader header;
	
	@JsonProperty("body")
	public MemberRequestBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public MemberRequestBody getBody() {
		return body;
	}

	public void setBody(MemberRequestBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MemberRequest [header=" + header + ", body=" + body + "]";
	}
}
