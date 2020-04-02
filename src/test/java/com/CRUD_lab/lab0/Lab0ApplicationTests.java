package com.CRUD_lab.lab0;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.CRUD_lab.lab0.Controller.AppController;
import com.CRUD_lab.lab0.models.Product;
import com.CRUD_lab.lab0.service.ProductService;
import com.CRUD_lab.lab0.shared.Utils;



@RunWith(SpringRunner.class)
@WebMvcTest
class Lab0ApplicationTests {
	
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext context;
	
	@MockBean
	ProductService productService;
	
	@Autowired
	Utils utils;
	
	@Mock
	Product product;
	
	@Test
	public void contextLoads() throws Exception{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@Test
	public void viewHomePageTest() throws Exception {	
		when(productService.listAll()).thenReturn(Arrays.asList(product));
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)
				).andReturn();
	//	System.out.println(mvcResult.getResponse());
		verify(productService).listAll();
	}
	
	@Test
	public void saveProductTest() throws Exception {
		
		ResultMatcher viewMatcher = MockMvcResultMatchers.view()
                .name("redirect:/");

			MockHttpServletRequestBuilder builder =
			MockMvcRequestBuilders.post("/save");


			this.mockMvc.perform(builder)
			.andExpect(viewMatcher)
			;
	}
	
	
	@Test
	public void deleteProductTest() throws Exception {
		
		int randomNum = ThreadLocalRandom.current().nextInt(1, 20 + 1);
		
		ResultMatcher viewMatcher = MockMvcResultMatchers.view()
                .name("redirect:/");

			MockHttpServletRequestBuilder builder =
			MockMvcRequestBuilders.post("/delete/"+randomNum);


			this.mockMvc.perform(builder)
			.andExpect(viewMatcher)
			;
		
	}
	
	
	@Test
	public void newProductForm () throws Exception {
		
		int randomNum = ThreadLocalRandom.current().nextInt(1, 20 + 1);
		
        MockHttpServletRequestBuilder builder =
                            MockMvcRequestBuilders.post("/add")
                                                  .param("id", ""+randomNum)
                                                  .param("prod_ref","mock_ref")
                                                  .param("prod_name", "mock_name")
                                                  .param("prod_brand", "mock_brand")
                                                  .param("prod_price",""+22.5)
                                                  ;
        this.mockMvc.perform(builder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.view().name("new_product"));
    }
	
	
	
	/*@Test
	public void showUpdateFormTest() throws Exception {
		AppController controller = new AppController();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 20 + 1);
		ModelAndView modelAndView = controller.showUpdateForm((long) randomNum);
		ResultMatcher created = MockMvcResultMatchers.status()
                .isCreated();

		MockHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.put("/update/"+randomNum)
				.param("id", ""+randomNum)
                .param("prod_ref","mock_ref")
                .param("prod_name", "mock_name")
                .param("prod_brand", "mock_brand")
                .param("prod_price",""+22.5)
                .contentType("application/x-www-form-urlencoded")
                .accept(MediaType.TEXT_PLAIN);
	
	this.mockMvc.perform(builder)
	.andExpect(MockMvcResultMatchers.model().attribute("new_product", modelAndView))
	;
	}*/
}