package com.medicare.capproject;
import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContext.class })
@WebAppConfiguration
public class CapstoneMediCareApplicationTests {
	
	@Autowired
	private WebApplicationContext webappcontext;
	
	protected MockMvc mockMVC;
	
	@Before
	public void setup() throws Exception{
		this.mockMVC=MockMvcBuilders.webAppContextSetup(this.webappcontext).build();
	}
	@Test
	public void givenWac_whenServletContext_thenItProvidesHomeController()
	{
		ServletContext servcontext=webappcontext.getServletContext();
		Assert.assertNotNull(servcontext);
		Assert.assertTrue(servcontext instanceof MockServletContext);
		Assert.assertNotNull(webappcontext.getBean("WelcomeMedicareController"));	
	}
	
	
	
}
