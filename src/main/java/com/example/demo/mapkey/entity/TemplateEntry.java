package com.example.demo.mapkey.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.demo.mapkey.TemplateEntryId;

@Entity(name="template_entry")
@IdClass(TemplateEntryId.class)
public class TemplateEntry implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	long id;
	
	/* ONLY ADD @ID FOR THE COLUMNS NEEDED FOR THE MAP JOIN */
	@Id
	long orgId;
	@Id
	long templateId;

	private String key;
	
    private String value;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + (int) (templateId ^ (templateId >>> 32));
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		TemplateEntry other = (TemplateEntry) obj;
		if (orgId != other.orgId)
			return false;
		if (id != other.id)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (templateId != other.templateId)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}