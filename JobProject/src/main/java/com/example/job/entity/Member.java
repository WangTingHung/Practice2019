package com.example.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**	 
 * @author Rick;	 
 * @param 
 * @return return_type
 * @see com.example.job.entity#mathod()	 
 * @date 2019年9月28日	 
 */
@Entity
@Table(name = "member")
public class Member {
	
	private static final long serialVersionUID = -7651300206111130013L;
	
	@Id
	@Column (name = "seq")
	private Integer seq;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "phone")
	private String phone;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
