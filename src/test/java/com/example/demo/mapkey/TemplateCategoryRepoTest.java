package com.example.demo.mapkey;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.mapkey.entity.TemplateEntry;
import com.example.demo.mapkey.entity.TemplateCategory;
import com.example.demo.mapkey.repo.TemplateCategoryRepo;
import com.example.demo.mapkey.repo.TemplateEntryRepo;

@SpringBootTest
public class TemplateCategoryRepoTest {

	@Autowired
	TemplateCategoryRepo kvsRepo;

	@Autowired
	TemplateEntryRepo entryRepo;

	@Test
	@Transactional
	void testMapData() {
		
		List<TemplateEntry> kvList = entryRepo.findAll();
		boolean hasData = !kvList.isEmpty();
		Assert.isTrue(hasData,"no keyValue data found");
		TemplateEntry kv = kvList.get(0);
		TemplateCategoryId id = new TemplateCategoryId();
		id.setOrgId(kv.getOrgId());
		id.setSubCategoryId(kv.getSubCategoryId());

		Optional<TemplateCategory> result = kvsRepo.findById(id);
		hasData = result.isPresent();
		Assert.isTrue(hasData,"no data found");
		
		TemplateCategory kvc = result.get();
		Map<String,TemplateEntry> kvMap = kvc.getKeyMap();
		Assert.isTrue(!kvMap.isEmpty(),"data map empty");
		Assert.isTrue(kvMap.size()==5,"data map improperly implemented");
		
	}

	@Test
	@Transactional
	void testFindAll() {
		List<TemplateCategory> result = kvsRepo.findAll();
		boolean hasData = !result.isEmpty();
		Assert.isTrue(hasData,"no data found");
		Assert.isTrue(result.size()==6,"data map improperly implemented");
	}

}
