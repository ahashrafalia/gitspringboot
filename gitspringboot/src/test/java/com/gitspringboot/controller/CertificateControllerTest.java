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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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

	//list
	@Test
	public void certSearchTest() throws Exception {
		mockMvc.perform(get("/rest/secured/cert")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$[0].certId").value(18)).andExpect(jsonPath("$[0].clientId").value(2)) 
				.andExpect(jsonPath("$[0].certName").value("Desert")).andExpect(jsonPath("$[0].certStatus").value("NEW"));

	}
	
	//Get
	@Test
	public void verifyCertById() throws Exception {
		mockMvc.perform(get("/rest/secured/cert/18").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.certId").exists())
		.andExpect(jsonPath("$.clientId").exists())
		.andExpect(jsonPath("$.certName").exists())
		.andExpect(jsonPath("$.certId").value(18))
		.andExpect(jsonPath("$.clientId").value(2))
		.andExpect(jsonPath("$.certName").value("Desert"));
		
	}
	@Test
	public void verifyInvalidCertArgument() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/secured/cert/f").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.errorCode").value(400))
			.andExpect(jsonPath("$.message").value("The request could not be understood by the server due to malformed syntax."));
			//.andDo(print());
	}
	@Test
	public void verifyInvalidCertId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/secured/cert/100").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Certificate does not exists"));

	}
	//@Test
	public void verifyNullToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/6").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("ToDo doesn´t exist"));
	}
	//@Test
	public void verifyDeleteToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/rest/secured/cert/6").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value(200))
		.andExpect(jsonPath("$.message").value("Cert has been deleted"));
		
	}
	
	@Test
	public void verifyInvalidToDoIdToDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/rest/secured/cert/6").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Certificate does not exists"));
		//.andDo(print());
	}
	
	//@Test
	public void verifySaveToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/secured/cert")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"certName\" : \"New Cert Sam\", \"clientId\" : 2 }")
		.accept(MediaType.APPLICATION_JSON))
		//.andExpect(jsonPath("$.certId").exists())
		//.andExpect(jsonPath("$.certName").exists());
		.andExpect(jsonPath("$.status").value(200));

		
	}
	
	@Test
	public void verifyUpdateToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/rest/secured/cert/7")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{  \"certName\" : \"ENBD Bank\" }")
        .accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.certId").exists())
		.andExpect(jsonPath("$.certName").exists())
		.andExpect(jsonPath("$.certName").value("ENBD Bank"));
		
		
	}

}
