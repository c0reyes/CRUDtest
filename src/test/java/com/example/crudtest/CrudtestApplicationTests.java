package com.example.crudtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.crudtest.controller.CrudController;

@SpringBootTest
class CrudtestApplicationTests {
	@Autowired
	private CrudController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
