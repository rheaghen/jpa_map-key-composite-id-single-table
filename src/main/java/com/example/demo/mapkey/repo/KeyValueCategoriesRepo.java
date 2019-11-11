package com.example.demo.mapkey.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.mapkey.Category;
import com.example.demo.mapkey.entity.KeyValueCategories;

@Repository
public interface KeyValueCategoriesRepo  extends JpaRepository<KeyValueCategories,Category> {

}
