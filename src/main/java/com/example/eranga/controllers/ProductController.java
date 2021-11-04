package com.example.eranga.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

@GetMapping("/")
public  String home() {
	System.out.print("Hello");
	Map<String, String> map=new HashMap();
	map.put("message", "Welcome to E-ranga app");
	
	return map.toString();
}

@PostMapping("/product/add")
public  Product addProduct(@RequestBody Product product) {
	return productDao.save(product);
}
@GetMapping("/product/all")
public  List<Product> getProducts() {
	return productDao.findAll();
}

@GetMapping("/product/{pid}")
public  Optional<Product> getOneProduct(@PathVariable("pid") long pid) {
	
	return productDao.findById(pid);
}
@DeleteMapping("/product/{pid}")
public  String deleteProduct(@PathVariable("pid") long pid) {
	
	productDao.deleteById(pid);
	
	return "Deleted";
}
@PutMapping("product/update")
public Product updateProduct(@RequestBody Product product) {
	return productDao.save(product);
}
}

