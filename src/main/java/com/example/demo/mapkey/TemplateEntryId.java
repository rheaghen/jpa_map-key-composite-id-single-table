package com.example.demo.mapkey;

import java.io.Serializable;

public class TemplateEntryId implements Serializable {

	private static final long serialVersionUID = 1L;

	long id;

	long orgId;

	long templateId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public long getSubCategoryId() {
		return templateId;
	}

	public void setSubCategoryId(long templateId) {
		this.templateId = templateId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orgId ^ (orgId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (templateId ^ (templateId >>> 32));
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
		TemplateEntryId other = (TemplateEntryId) obj;
		if (orgId != other.orgId)
			return false;
		if (id != other.id)
			return false;
		if (templateId != other.templateId)
			return false;
		return true;
	}

}