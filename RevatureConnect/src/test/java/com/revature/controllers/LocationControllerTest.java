package com.revature.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.revature.models.Location;
import com.revature.service.LocationService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class LocationControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private LocationService locationService;

//	@Test
//	void getAllLocations() throws Exception {
//		List<Location> locations = new ArrayList<>();
//		locations.add(new Location(5, "Houston, Texas"));
//		locations.add(new Location(5, "Jackson, New Jersey"));
//		when(locationService.findAll()).thenReturn(locations);
//
//		mockMvc.perform(MockMvcRequestBuilders.get("/locations")
//				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)).
//		andExpect(jsonPath("$", hasSize(2)))
//				.andDo(print());
//
//	}
	
	@Test
	void deleteLocation() throws Exception { 
		List<Location> locations = new ArrayList<>(); 
		locations.add(new Location(1, "Sydney, Australia"));
		locations.add(new Location(2, "LizardLick, Texas")); 
		locations.remove(0); 
		when(locationService.remove(1)).thenReturn(locations);
		mockMvc.perform(MockMvcRequestBuilders.delete("/remove/1").
				contentType(org.springframework.http.MediaType.APPLICATION_JSON)).
		andExpect(jsonPath("$", hasSize(1))).
			andDo(print()); 

  @Test
	void getAllLocations() throws Exception {
		List<Location> locations = new ArrayList<>();
		locations.add(new Location(5, "Houston, Texas"));
		locations.add(new Location(5, "Jackson, New Jersey"));
		when(locationService.findAll()).thenReturn(locations);

		mockMvc.perform(MockMvcRequestBuilders.get("/locations")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)).
		andExpect(jsonPath("$", hasSize(2)))
				.andDo(print());

	}
	
}
