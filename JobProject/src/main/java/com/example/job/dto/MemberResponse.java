package com.example.job.dto;



import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberResponse {

	@JsonProperty("header")
	public CommonHeader header;

	@JsonProperty("body")
	public MemberResponseBody body;

	public CommonHeader getHeader() {
		return header;
	}

	public void setHeader(CommonHeader header) {
		this.header = header;
	}

	public MemberResponseBody getBody() {
		return body;
	}

	public void setBody(MemberResponseBody body) {
		this.body = body;
	}


	@Override
	public String toString() {
		return "MemberResponse [header=" + header + ", body=" + body + "]";
	}
}
