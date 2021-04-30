package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.revature.models.CategoryType;
import com.revature.models.Location;
import com.revature.models.Posts;
import com.revature.repositories.PostRepository;

@WebMvcTest(value=PostController.class)
class PostControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	//mocking data
	Location loc = new Location(1,"mockLocation");
	@MockBean
	private PostRepository postRepository;
	
	@Enumerated(EnumType.STRING)
	CategoryType ctype;
	Posts mockpost = new Posts(1,"dtitle","dcontent",loc,CategoryType.Housing);
	List<Posts> mockpostList = new ArrayList<Posts>();
	
	
	@Test
	void test1() throws Exception {

		mockpostList.add(mockpost);
		Mockito.when(
				postRepository.findAll()).thenReturn(mockpostList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/post/").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
	
	String expected = "[{id:1,title:dtitle,content:dcontent,location:{},categoryType:Housing}]";
	System.out.println("-----------------------------------------------");
	System.out.println(expected);
	System.out.println(result.getResponse().getContentAsString());
	System.out.println("-----------------------------------------------");
	JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),true);
	
	}
	
	@Test
	void test2() throws  Exception {

	}
	
	@Test
	void test3() {
		assertTrue(true);
	}
	
	@Test
	void test4() {
		assertFalse(false);
	}
	
	@Test
	void test5() {
		assertEquals(true,true);
	}
	
	

}
