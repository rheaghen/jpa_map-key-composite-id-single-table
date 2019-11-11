package com.example.demo.mapkey;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.mapkey.entity.KeyValue;
import com.example.demo.mapkey.entity.KeyValueCategories;
import com.example.demo.mapkey.repo.KeyValueCategoriesRepo;
import com.example.demo.mapkey.repo.KeyValueRepo;

@SpringBootTest
public class KeyValueCategoriesRepoTest {

	@Autowired
	KeyValueCategoriesRepo kvsRepo;

	@Autowired
	KeyValueRepo kvRepo;

	@Test
	@Transactional
	void testMapData() {
		
		List<KeyValue> kvList = kvRepo.findAll();
		boolean hasData = !kvList.isEmpty();
		Assert.isTrue(hasData,"no keyValue data found");
		KeyValue kv = kvList.get(0);
		Category id = new Category();
		id.setCategoryId(kv.getCategoryId());
		id.setSubCategoryId(kv.getSubCategoryId());

		Optional<KeyValueCategories> result = kvsRepo.findById(id);
		hasData = result.isPresent();
		Assert.isTrue(hasData,"no data found");
		
		KeyValueCategories kvc = result.get();
		Map<String,KeyValue> kvMap = kvc.getKeyMap();
		Assert.isTrue(kvMap.isEmpty(),"data map empty");
		Assert.isTrue(kvMap.size()==5,"data map improperly implemented");
		
	}

	@Test
	@Transactional
	void testFindAll() {
		List<KeyValueCategories> result = kvsRepo.findAll();
		boolean hasData = !result.isEmpty();
		Assert.isTrue(hasData,"no data found");
		Assert.isTrue(result.size()==6,"data map improperly implemented");
	}

}
