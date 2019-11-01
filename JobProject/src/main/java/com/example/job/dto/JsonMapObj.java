package com.example.job.dto;

import java.io.Serializable;

public class JsonMapObj implements Serializable {
	
	private static final long serialVersionUID = 7915964307409565892L;
	
	/***********************
	 * Field
	 ***********************/
	private Object key;
	private Object value;
	
	/***********************
	 * Constractor
	 ***********************/
	
	/**
	 * @param key
	 * @param value
	 */
	public JsonMapObj(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	/**
	 * Result : {key: key, value : value (addition)}
	 * @param key
	 * @param value
	 * @param addtion
	 */
	public JsonMapObj(Object key, Object value, Object addition) {
		super();
		this.key = key;
		this.value = value + " ("+ addition +")";
	}
	
	/**
	 * Result : {key: key, value : value (addition)}
	 * @param key
	 * @param value
	 * @param addtion
	 */
	public JsonMapObj(Object key, Object value, Object addition1, Object addition2) {
		super();
		this.key = key;
		this.value = value + " ("+ addition1 +" ,"+addition2+") ";
	}
	
	public JsonMapObj() {
		super();
	}

	/***********************
	 * Getter & Setter
	 ***********************/
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "JsonMapObj [key=" + key + ", value=" + value + "]";
	}
}
