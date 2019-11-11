package com.example.demo.mapkey;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.mapkey.entity.KeyValue;
import com.example.demo.mapkey.repo.KeyValueRepo;

@SpringBootTest
public class KeyValueRepoTest {

	@Autowired
	KeyValueRepo repo;

	@Test
	void test() {
		List<KeyValue> all = repo.findAll();
		Assert.isTrue(!all.isEmpty(),"no data found");
		Assert.isTrue(all.size()==30,"Unexpected data size");
	}

}
