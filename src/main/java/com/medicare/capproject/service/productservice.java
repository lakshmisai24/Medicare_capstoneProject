package com.medicare.capproject.service;
import java.util.List;
import java.util.Optional;

import com.medicare.capproject.model.products;



public interface productservice {
	void saveproducts(products product);
	List<products> getAllActiveProducts();
	void deleteproductbyId(long id);


}
