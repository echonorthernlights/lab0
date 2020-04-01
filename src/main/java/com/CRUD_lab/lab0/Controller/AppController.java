package com.CRUD_lab.lab0.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.CRUD_lab.lab0.models.Product;
import com.CRUD_lab.lab0.service.ProductService;
import com.CRUD_lab.lab0.shared.Utils;

@Controller
@ComponentScan("com.CRUD_lab.lab0")
public class AppController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	Utils utils;
	
	@RequestMapping(value = "/")
	public String viewHomePage(Model model)
	{
		List<Product> listProducts = productService.listAll();
		model.addAttribute("listOfProducts", listProducts);
		return "index";
	}
	
	@RequestMapping(value = "/add")
	public String newProductForm(Model model)
	{
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product)
	{

		product.setProd_ref(utils.generateProductId(5));
		productService.saveProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update/{id}")
	public ModelAndView showUpdateForm(@PathVariable(name = "id") Long id)
	{
		ModelAndView mav = new ModelAndView("update_product");
		Product product = productService.getProduct(id);
		mav.addObject("product", product);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id)
	{
		productService.deleteProduct(id);
		
		return "redirect:/";
	}
	
}
