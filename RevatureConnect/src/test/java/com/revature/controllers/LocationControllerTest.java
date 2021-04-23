package com.revature.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Location;
import com.revature.service.LocationService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LocationController.class)
public class LocationControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private LocationService locationService;

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
	
	@Test
	void getAllLocationsPost() throws Exception {
		Location location = new Location(5, "Houston, Texas");
		when(locationService.save(Mockito.any(Location.class))).thenReturn(location);

		mockMvc.perform(MockMvcRequestBuilders.post("/locationspost")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(toJson(location)))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json")).andDo(print());
		
	}

	private String toJson(Location location) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		String locAsString = om.writeValueAsString(location);
		return locAsString;
	}
}
