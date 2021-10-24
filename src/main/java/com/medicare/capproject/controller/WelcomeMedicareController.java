package com.medicare.capproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.medicare.capproject.service.customerserviceimpl;
import com.medicare.capproject.service.productserviceimpl;
import com.medicare.capproject.model.*;

@Controller
public class WelcomeMedicareController {
	
	@Autowired
	private customerserviceimpl customerserve;
	private productserviceimpl productserve;
	

	@RequestMapping(value="/MedicareHomePage",method=RequestMethod.GET)
	public String showHomePage(ModelMap model)
	{
		return "MedicareHomePage";
	}
	
	@GetMapping("/showLoginPage")
	public String showLoginPage(ModelMap model)
	{
		model.addAttribute("login", new Object());

		return "LoginPage";
	}

	@PostMapping("/savecustomer")
	public String savecustomer(@ModelAttribute("customers") customers cust)
	{		
		customerserve.savecustomer(cust);
		return "LoginAfterRegister";
	}
	
	
	@PostMapping(value="/logincustomer")
	public String logincustomer(ModelMap model)
	{		
			return "AdminAddProduct";

     }
	
	@PostMapping("/saveProducts")
	public String saveProducts(@ModelAttribute("products") products product)
	{		
		productserve.saveproducts(product);
		return "ShowProducts";
	}
	
	@GetMapping("/ShowMecinesPage")
	public String ShowMecinesPage(ModelMap model)
	{
		model.addAttribute("Addmedicine", new Object());

		return "Addmedicinestocart";
	}


}

