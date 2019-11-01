package com.example.job.dto;

import java.util.HashMap;
import java.util.Map;

import com.example.job.enums.ErrorCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Common AJAX response.
 * 
 * <p>Enum "Status" represents status of response, constructs of two arguments: status name and HTTP code. In JSON output, it shall be shown as
 * <code>{status:{name: "xxx", code: ooo}}</code> </p>
 * 
 * <p>In addition, except "title" and "message", if there are any other informations should wrap into this object, store them into map "others". 
 * For convenience sake, the method "addOther" has provided.</p>
 * 
 * @author freddyfang
 */
@JsonInclude(Include.NON_NULL)
public class AsyncResponse {
	
//	/*-----------------------
//	 * Status enum
//	 -----------------------*/
//	public enum TemplateErrorCode implements ErrorCode{
//		TEMPLATE("Error Code","Error Message");
//		
//		private String errorCode;
//		private String errorMsg;
//		
//		TemplateErrorCode(String errorCode, String errorMsg){
//			this.errorCode = errorCode;
//			this.errorMsg = errorMsg;
//		}
//
//		@Override
//		public String i18nMsg() {
//			return this.errorMsg;
//		}
//
//		@Override
//		public String errorCode() {
//			return this.errorCode;
//		}
//
//		public String getErrorCode() {
//			return errorCode;
//		}
//
//		public void setErrorCode(String errorCode) {
//			this.errorCode = errorCode;
//		}
//
//		public String getErrorMsg() {
//			return errorMsg;
//		}
//
//		public void setErrorMsg(String errorMsg) {
//			this.errorMsg = errorMsg;
//		}
//	}
	
	/*-----------------------
	 * Status enum
	 -----------------------*/
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum HttpStatus {
		SUCCESS("success", 200),
		FAILED("failed", 500),
		FORBIDDEN("Forbidden", 403),
		UNAUTHORIZED("unauth", 401),
		PRECONDITION_FAILED("Precondition Failed", 412),
		GONE("Gone", 410),
		BAD_REQUEST("Bad Request",400),
		RESET_CONTENT("Reset Content", 205);
		
		
		private String message;
		private Integer code;
		
		private HttpStatus(String name, Integer code) {
			this.message = name;
			this.code = code;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}
	}
	
	public AsyncResponse() {
		this.status = HttpStatus.SUCCESS;
	}
	
	/*-----------------------
	 * Fields
	 -----------------------*/
	private HttpStatus status;
	private String title;
	private String header;
	private String message;
	private Object data;
	private Map<String, Object> others;
	

	private ErrorCode errorCode;
	
	/*-----------------------
	 * Getters and Setters
	 -----------------------*/
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getOthers() {
		return others;
	}
	public void setOthers(Map<String, Object> others) {
		this.others = others;
	}
	public void addOther(String key, Object value) {
		if(this.others == null)
			this.others = new HashMap<String, Object>();
		
		this.others.put(key, value);
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "AsyncResponse [status=" + status + ", title=" + title + ", header=" + header + ", message=" + message
				+ ", data=" + data + ", others=" + others + ", errorCode=" + errorCode + "]";
	}
}