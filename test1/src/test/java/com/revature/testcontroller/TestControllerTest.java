package com.revature.testcontroller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private TestController tc;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(tc).build();
	}
	
	@Test
	public void test() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/test")
				)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello world"));
	}

	
}
