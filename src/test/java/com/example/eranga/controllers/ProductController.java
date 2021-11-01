package com.example.eranga.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eranga.dao.ProductDao;
import com.example.eranga.entities.Product;

@RestController
public class ProductController {
	
@Autowired
ProductDao productDao;

@RequestMapping(value="/",method=RequestMethod.GET)
@ResponseBody()
public  String home() {
	System.out.print("Hello");
	Map<String, String> map=new HashMap();
	map.put("message", "Welcome to E-ranga app");
	
	return map.toString();
}

@RequestMapping("/product/add")
public  Product addProduct(@RequestBody Product product) {
	return productDao.save(product);
}
@GetMapping("/product/all")
public  List<Product> getProducts() {
	return productDao.findAll();
}
}
