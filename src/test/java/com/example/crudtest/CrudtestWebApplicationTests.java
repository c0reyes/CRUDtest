package com.example.crudtest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CrudtestWebApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void createPerson() throws Exception {
		this.mockMvc.perform(post("/create")
			.param("firstname","test")
			.param("lastname","test")
			.param("occupation","test"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Person saved")));
	}
	
	@Test
	public void updatePerson() throws Exception {
		this.mockMvc.perform(post("/update")
			.param("firstname","test")
			.param("lastname","test2")
			.param("occupation","test")
			.param("id","1"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Person updated")));
	}
	
	@Test
	public void readPerson() throws Exception {
		this.mockMvc.perform(post("/create")
				.param("firstname","test")
				.param("lastname","test")
				.param("occupation","test"));
		
		this.mockMvc.perform(get("/")
			.param("firstname","test")
			.param("lastname",""))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("test")));
	}
	
	@Test
	public void delPerson() throws Exception {
		this.mockMvc.perform(post("/create")
				.param("firstname","testdel")
				.param("lastname","testdel")
				.param("occupation","testdel"));
		
		this.mockMvc.perform(get("/delete")
			.param("id","2"))
			.andDo(print())
			.andExpect(content().string(containsString("Person deleted")));
	}

}
