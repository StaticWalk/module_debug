package com.xxy.module_debug.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by xiongxiaoyu
 * Data:2019/5/28
 * Time:11:12
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimalControllerTest {

	private final static Logger logger = LoggerFactory.getLogger(AnimalControllerTest.class);

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void initMock(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void createAnimal() throws Exception {
		String content = "{\"name\":\"elephant\",\"password\":66,\"birthDay\":"+System.currentTimeMillis()+"}";
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/animal")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse().getContentAsString();
		logger.info(result);
	}
}
