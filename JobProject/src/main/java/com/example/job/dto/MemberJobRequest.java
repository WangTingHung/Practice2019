package com.example.job.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberJobRequest {
	
	@JsonProperty("header")
	public CommonHeader header;
	
	@JsonProperty("body")
	public MemberJobRequestBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public MemberJobRequestBody getBody() {
		return body;
	}

	public void setBody(MemberJobRequestBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ProductRequest [header=" + header + ", body=" + body + "]";
	}
}
