package com.medicare.capproject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Test;
	
public class mediHomeTest extends CapstoneMediCareApplicationTests{
	
	@Test
	public void medihometestcontroller() throws Exception
	{
		this.mockMVC.perform(get("/")).andExpect(status().isOk()).
		andExpect(view().name("MedicareHomePage"))
		.andExpect(forwardedUrl("/templates/MedicareHomePage")) 
		.andExpect(model().size(1));
	}
}
