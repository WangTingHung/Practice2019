package com.example.job.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_project_icon")
@Access(AccessType.FIELD)
public class TestProjectIcon implements Serializable {

	private static final long serialVersionUID = 6858853668870294839L;

	@Id
	@Column(name="customer_id")
	private Integer customerId;

	@Id
	@Column(name="icon_id")
	private Integer iconId;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getIconId() {
		return iconId;
	}

	public void setIconId(Integer iconId) {
		this.iconId = iconId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((iconId == null) ? 0 : iconId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestProjectIcon other = (TestProjectIcon) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (iconId == null) {
			if (other.iconId != null)
				return false;
		} else if (!iconId.equals(other.iconId))
			return false;
		return true;
	}
	
	
	
}
