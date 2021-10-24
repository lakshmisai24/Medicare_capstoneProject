package com.medicare.capproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.capproject.model.customers;
import com.medicare.capproject.repository.CustomerRepository;

@Service
public class customerserviceimpl implements customerservice{
	@Autowired
	private CustomerRepository custrepo;
	@Override
	public void savecustomer(customers cust) {
		this.custrepo.save(cust);
	}

}
