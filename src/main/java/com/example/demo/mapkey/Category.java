package com.example.demo.mapkey;

import java.io.Serializable;

public class Category  implements Serializable 
{
	private static final long serialVersionUID = 1L;

	long categoryId;

	long subCategoryId;	

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (categoryId ^ (categoryId >>> 32));
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
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		if (subCategoryId != other.subCategoryId)
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}