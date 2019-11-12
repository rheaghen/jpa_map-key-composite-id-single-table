package com.example.demo.mapkey.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.mapkey.TemplateCategoryId;
import com.example.demo.mapkey.entity.TemplateEntry;

@Repository
public interface TemplateEntryRepo extends JpaRepository<TemplateEntry,TemplateCategoryId> {

}
