package com.revature.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.ResponseController;
import com.revature.model.Response;
import com.revature.service.ResponseService;

@RunWith(SpringRunner.class)
@WebMvcTest(ResponseController.class)
public class ResponseControllerPostTest {

	@Autowired 
	MockMvc mvc;
	
	@MockBean
	ResponseService rserv;
	
	@Test
	public void submitResponseTest() throws Exception {
		Response r = new Response();
		r.setContent("hello i am test");
		r.setPostId(1);
		
		mvc.perform(post("/api/v1/responses/submit-response")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(r)))
				.andExpect(status().isOk());
	}
	private String toJson(Response r) {
		try {
			return new ObjectMapper().writeValueAsString(r);
		  } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}
}
