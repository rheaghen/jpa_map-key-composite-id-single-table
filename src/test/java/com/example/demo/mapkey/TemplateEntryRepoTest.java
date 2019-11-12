package com.example.demo.mapkey;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.mapkey.entity.TemplateEntry;
import com.example.demo.mapkey.repo.TemplateEntryRepo;

@SpringBootTest
public class TemplateEntryRepoTest {

	@Autowired
	TemplateEntryRepo repo;

	@Test
	void test() {
		List<TemplateEntry> all = repo.findAll();
		Assert.isTrue(!all.isEmpty(),"no data found");
		Assert.isTrue(all.size()==30,"Unexpected data size");
	}

}
