package com.revature.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import com.revature.models.Location;
import com.revature.repositories.PostsRepository;
import com.revature.service.LocationService;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest(LocationController.class)
public class LocationControllerTest {

	@InjectMocks
	LocationController locationController;

	@Mock
	private LocationService locationService;

//	@Test
//	void deleteLocation() throws Exception { 
//		List<Location> locations = new ArrayList<>(); 
//		locations.add(new Location(1, "Sydney, Australia"));
//		locations.add(new Location(2, "LizardLick, Texas")); 
//		when(locationService.remove("")).thenReturn(locations);
//		mockMvc.perform(MockMvcRequestBuilders.delete("/remove/1").
//				contentType(org.springframework.http.MediaType.APPLICATION_JSON)).
//		andExpect(jsonPath("$", hasSize(1))).
//			andDo(print()); 
//	}


	@Test
	void testGetAllLocations() throws Exception {
		List<Location> locations = new ArrayList<>();

		Location location1 = new Location("Houston", "Texas");
		Location location2 = new Location("Jackson", "New Jersey");

		locations.add(location1);
		locations.add(location2);

		when(locationService.findAll()).thenReturn(locations);

		// when
		List<Location> resultLocations = locationController.getAllLocations();

		// then
		assertThat(resultLocations.size()).isEqualTo(2);

		assertThat(resultLocations.get(0)).isEqualTo(location1);
		assertThat(resultLocations.get(1)).isEqualTo(location2);
	}

	@Test
	void createLocation() throws Exception {

		Location location = new Location(5, "Houston", "Texas");



		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Location locationToReturn = new Location("Richmond", "Virginia");
		Location locationToSave = new Location("Richmond", "Virginia");
	
		when(locationService.save(locationToSave)).thenReturn(locationToReturn);

		ResponseEntity<Object> responseEntity = locationController.createNewLocation("Richmond", "Virginia");

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");

	}
	 

}
