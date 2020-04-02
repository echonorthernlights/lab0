package com.CRUD_lab.lab0;

import org.springframework.beans.factory.annotation.Autowired;

import com.CRUD_lab.lab0.models.Product;
import com.CRUD_lab.lab0.shared.Utils;

public class ProductRepositoryFake {
	
	@Autowired
	static
	Utils utils;
	
	static Product product = new Product();
	
	public Product mockProduct() {
		product.setId(60L);
		product.setProd_brand("mock_brand");
		product.setProd_name("mock_name");
		product.setProd_ref(utils.generateProductId(5));
		product.setProd_price(60.60);
		
		return product;
	}
		

}
