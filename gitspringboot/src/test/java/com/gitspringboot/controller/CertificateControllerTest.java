package com.gitspringboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.integration.util.FixedMethodFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gitspringboot.ArticalMain;
import com.gitspringboot.SpringBootTests;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ArticalMain.class)
@SpringBootTest
public class CertificateControllerTest {

	@Autowired
	private WebApplicationContext webAppCxt;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppCxt).build();
	}

	@Test
	public void certSearchTest() throws Exception {
		mockMvc.perform(get("/rest/secured/cert")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$[0].certId").value(10)).andExpect(jsonPath("$[0].clientId").value(2)) 
				.andExpect(jsonPath("$[0].certName").value("ANSARI Exchange")).andExpect(jsonPath("$[0].certStatus").value("NEW"));

	}
	@Test
	public void verifyToDoById() throws Exception {
		mockMvc.perform(get("/rest/secured/cert/10").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.certId").exists())
		.andExpect(jsonPath("$.clientId").exists())
		.andExpect(jsonPath("$.certName").exists())
		.andExpect(jsonPath("$.certId").value(10))
		.andExpect(jsonPath("$.clientId").value(2))
		.andExpect(jsonPath("$.certName").value("ANSARI Exchange"));
		
}
}
