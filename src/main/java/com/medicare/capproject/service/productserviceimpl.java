package com.medicare.capproject.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.capproject.model.customers;
import com.medicare.capproject.model.products;
import com.medicare.capproject.repository.CustomerRepository;
import com.medicare.capproject.repository.ProductRepository;


@Service
public class productserviceimpl {
	
	@Autowired
	private ProductRepository productrepo;
    
	public void saveproducts(products product) {
		this.productrepo.save(product);
	}

	public List<products> getAllActiveProducts() {
		return productrepo.findAll();
	}
	public void deleteproductbyId(long id) {
		// TODO Auto-generated method stub
		this.productrepo.deleteById(id);
	}




}
