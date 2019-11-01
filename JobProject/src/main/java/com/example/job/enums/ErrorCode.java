package com.example.job.enums;

public enum ErrorCode {
	E0001("系統錯誤"),
	E0002("尚未登入");
	
	private String errorMsg;
	
	private ErrorCode(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
