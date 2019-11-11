package com.example.demo.mapkey.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.mapkey.Category;

@Entity
@Table(name = "key_value_categories")
@IdClass(Category.class)
public class KeyValueCategories implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	long categoryId;
	@Id
	long subCategoryId;
	
	@OneToMany(targetEntity = KeyValue.class)
	@JoinColumns( {
		@JoinColumn(name = "categoryId",  referencedColumnName = "categoryId"),
		@JoinColumn(name = "subCategoryId",  referencedColumnName = "subCategoryId")
		}
	)
	@MapKeyColumn(name="key",insertable = false, table = "key_value")
	private Map<String, KeyValue> keyMap;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Map<String, KeyValue> getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(Map<String, KeyValue> keyMap) {
		this.keyMap = keyMap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (categoryId ^ (categoryId >>> 32));
		result = prime * result + ((keyMap == null) ? 0 : keyMap.hashCode());
		result = prime * result + (int) (subCategoryId ^ (subCategoryId >>> 32));
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
		KeyValueCategories other = (KeyValueCategories) obj;
		if (categoryId != other.categoryId)
			return false;
		if (keyMap == null) {
			if (other.keyMap != null)
				return false;
		} else if (!keyMap.equals(other.keyMap))
			return false;
		if (subCategoryId != other.subCategoryId)
			return false;
		return true;
	}


}
