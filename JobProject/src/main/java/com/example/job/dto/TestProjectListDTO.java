package com.example.job.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class TestProjectListDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2054574533376985087L;

	private Integer seq;
	
	private String groupName;
	
	private String customerName;
	
	private String customerId;
	
	private String msr;
	
	private BigDecimal rorwa;
	
	private BigDecimal raroc;

	private Integer lastYear;
	
	private Integer thisYear;
	
	private Integer storeAmount;
	
	private Integer releaseAmount;
	
	private Integer tradeBalance;
	
	private List<Integer> icons;

	
	
	public TestProjectListDTO(Integer seq, String groupName, String customerName, String customerId, String msr,
			BigDecimal rorwa, BigDecimal raroc, Integer lastYear, Integer thisYear, Integer storeAmount,
			Integer releaseAmount, Integer tradeBalance) {
		super();
		this.seq = seq;
		this.groupName = groupName;
		this.customerName = customerName;
		this.customerId = customerId;
		this.msr = msr;
		this.rorwa = rorwa;
		this.raroc = raroc;
		this.lastYear = lastYear;
		this.thisYear = thisYear;
		this.storeAmount = storeAmount;
		this.releaseAmount = releaseAmount;
		this.tradeBalance = tradeBalance;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMsr() {
		return msr;
	}

	public void setMsr(String msr) {
		this.msr = msr;
	}

	public BigDecimal getRorwa() {
		return rorwa;
	}

	public void setRorwa(BigDecimal rorwa) {
		this.rorwa = rorwa;
	}

	public BigDecimal getRaroc() {
		return raroc;
	}

	public void setRaroc(BigDecimal raroc) {
		this.raroc = raroc;
	}

	public Integer getLastYear() {
		return lastYear;
	}

	public void setLastYear(Integer lastYear) {
		this.lastYear = lastYear;
	}

	public Integer getThisYear() {
		return thisYear;
	}

	public void setThisYear(Integer thisYear) {
		this.thisYear = thisYear;
	}

	public Integer getStoreAmount() {
		return storeAmount;
	}

	public void setStoreAmount(Integer storeAmount) {
		this.storeAmount = storeAmount;
	}

	public Integer getReleaseAmount() {
		return releaseAmount;
	}

	public void setReleaseAmount(Integer releaseAmount) {
		this.releaseAmount = releaseAmount;
	}

	public Integer getTradeBalance() {
		return tradeBalance;
	}

	public void setTradeBalance(Integer tradeBalance) {
		this.tradeBalance = tradeBalance;
	}

	public List<Integer> getIcons() {
		return icons;
	}

	public void setIcons(List<Integer> icons) {
		this.icons = icons;
	}
	
	
}
