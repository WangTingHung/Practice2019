package com.example.job.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "member_job")

public class MemberJob implements Serializable {

	private static final long serialVersionUID = -7651300206111130013L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private Integer seq;

	@Column(name = "member_seq")
	private Integer memberSeq;

	@Column(name = "job_seq")
	private Integer jobSeq;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(Integer memberSeq) {
		this.memberSeq = memberSeq;
	}

	public Integer getJobSeq() {
		return jobSeq;
	}

	public void setJobSeq(Integer jobSeq) {
		this.jobSeq = jobSeq;
	}


}
