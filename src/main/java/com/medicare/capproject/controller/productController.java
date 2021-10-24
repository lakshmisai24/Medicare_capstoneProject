package com.medicare.capproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.medicare.capproject.model.*;
import com.medicare.capproject.service.productserviceimpl;


import com.medicare.capproject.service.ImageUtil;

@Controller
public class productController {
	
	@Value("${upoadDir}")
	private String uploadFolder;

	@Autowired
	private productserviceimpl productService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());


	@PostMapping("/saveproducts")
	public @ResponseBody ResponseEntity<?> createEmployee(@RequestParam("productname") String name,
			@RequestParam("price") float price, Model model, HttpServletRequest request
			,final @RequestParam("image") MultipartFile file) {
		try {
			//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			log.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			log.info("FileName: " + file.getOriginalFilename());
			if (fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			String[] names = name.split(",");
			log.info("Name: " + names[0]+" "+filePath);
			log.info("price: " + price);
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			products product = new products();
			product.setProductname(names[0]);
			product.setImage(imageData);
			product.setPrice(price);
			productService.saveproducts(product);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/showproducts")
	public String showproducts(Model model)
	{
		model.addAttribute("imgUtil", new ImageUtil());
		model.addAttribute("listproducts", productService.getAllActiveProducts());
		return "displayproducts";
	}
		
	@GetMapping("/deleteproduct/{id}")
	public String deleteproduct(@PathVariable ( value ="id" ) long id)
	{
		//call delete shoe method
		this.productService.deleteproductbyId(id);
		return "redirect:/displayproducts";
	}

	

	
}	



