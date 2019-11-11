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

@SpringBootTest
public class KeyValueCategoriesRepoTest {

	@Autowired
	KeyValueCategoriesRepo kvsRepo;

	@Test
	@Transactional
	void testMapData() {	
		Category id = new Category();
		id.setCategoryId(1);
		id.setSubCategoryId(1);
		Optional<KeyValueCategories> result = kvsRepo.findById(id);
		boolean hasData = result.isPresent();
		Assert.isTrue(hasData,"no data found");
		KeyValueCategories kvc = result.get();
		Map<String,KeyValue> kv = kvc.getKeyMap();
		Assert.isTrue(kv.isEmpty(),"data map empty");
		Assert.isTrue(kv.size()==5,"data map improperly implemented");
		
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
