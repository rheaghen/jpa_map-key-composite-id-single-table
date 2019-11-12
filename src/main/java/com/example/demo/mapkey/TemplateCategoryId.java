package com.example.demo.mapkey;

import java.io.Serializable;

public class TemplateCategoryId  implements Serializable 
{
	private static final long serialVersionUID = 1L;

	long orgId;

	long templateId;	

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orgId ^ (orgId >>> 32));
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
		TemplateCategoryId other = (TemplateCategoryId) obj;
		if (orgId != other.orgId)
			return false;
		if (templateId != other.templateId)
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}