package com.example.demo.mapkey.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.mapkey.TemplateCategoryId;

@Entity
@Table(name = "template_categories")
@IdClass(TemplateCategoryId.class)
public class TemplateCategory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	long orgId;
	@Id
	long templateId;
	
	@OneToMany(targetEntity = TemplateEntry.class)
	@JoinColumns( {
		@JoinColumn(name = "orgId",  referencedColumnName = "orgId"),
		@JoinColumn(name = "templateId",  referencedColumnName = "templateId")
		}
	)
	@MapKey(name="key")
	private Map<String, TemplateEntry> keyMap;

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Map<String, TemplateEntry> getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(Map<String, TemplateEntry> keyMap) {
		this.keyMap = keyMap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orgId ^ (orgId >>> 32));
		result = prime * result + ((keyMap == null) ? 0 : keyMap.hashCode());
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
		TemplateCategory other = (TemplateCategory) obj;
		if (orgId != other.orgId)
			return false;
		if (keyMap == null) {
			if (other.keyMap != null)
				return false;
		} else if (!keyMap.equals(other.keyMap))
			return false;
		if (templateId != other.templateId)
			return false;
		return true;
	}


}
