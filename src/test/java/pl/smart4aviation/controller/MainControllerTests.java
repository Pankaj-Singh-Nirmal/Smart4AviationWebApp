package pl.smart4aviation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@DisplayName("Tests for class MainController")
class MainControllerTests 
{
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	@DisplayName("Should Load Home Page")
	void shouldLoadHomePage() throws Exception 
	{
		/** given **/
		String viewName = "home-page";
		String forwardedUrl = "/WEB-INF/view/home-page.jsp";
		
		mockMvc.perform(get("/"))			/** when **/
			   .andExpect(status().isOk())	/** then **/
			   .andExpect(view().name(viewName))
			   .andExpect(forwardedUrl(forwardedUrl));
	}
	
	@Test
	@DisplayName("Should Load Calculation Page")
	void shouldLoadCalculationPage() throws Exception 
	{
		/** given **/
		String viewName = "home-page";
		String forwardedUrl = "/WEB-INF/view/home-page.jsp";
		
		mockMvc.perform(get("/processCalculation"))		/** when **/
			   .andExpect(status().isOk())				/** then **/
			   .andExpect(view().name(viewName))
			   .andExpect(forwardedUrl(forwardedUrl));
	}
	
	@Test
	@DisplayName("Should Return 404 Not Found Status")
	void shouldReturn404NotFoundStatus() throws Exception 
	{
		/** given **/
		String invalidUrl = "/thisUrlIsInvalid";
		
		mockMvc.perform(get(invalidUrl))				/** when **/
			   .andExpect(status().isNotFound());		/** then **/
	}

}
