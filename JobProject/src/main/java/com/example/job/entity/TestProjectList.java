package com.example.job.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test_project_list")
@Access(AccessType.FIELD)
public class TestProjectList implements Serializable{

	private static final long serialVersionUID = 787605429830985975L;
	

	/*********************** 
	 * Database Field
	 ***********************/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer seq;
	
	@Column(name="group_name")
	private String groupName;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="msr")
	private String msr;
	
	@Column(name="rorwa")
	private BigDecimal rorwa;
	
	@Column(name="raroc")
	private BigDecimal raroc;

	@Column(name="last_year")
	private Integer lastYear;
	
	@Column(name="this_year")
	private Integer thisYear;
	
	@Column(name="store_amount")
	private Integer storeAmount;
	
	@Column(name="release_amount")
	private Integer releaseAmount;
	
	@Column(name="trade_balance")
	private Integer tradeBalance;

	@OneToMany(cascade=CascadeType.ALL,mappedBy = "customerId")
	private List<TestProjectIcon> icons;
	
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

	public List<TestProjectIcon> getIcons() {
		return icons;
	}

	public void setIcons(List<TestProjectIcon> icons) {
		this.icons = icons;
	}

	@Override
	public String toString() {
		return "TestProjectList [seq=" + seq + ", groupName=" + groupName + ", customerName=" + customerName
				+ ", customerId=" + customerId + ", msr=" + msr + ", rorwa=" + rorwa + ", raroc=" + raroc
				+ ", lastYear=" + lastYear + ", thisYear=" + thisYear + ", storeAmount=" + storeAmount
				+ ", releaseAmount=" + releaseAmount + ", tradeBalance=" + tradeBalance + "]";
	}




}
