package com.example.ProductCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductCrud.beans.Product;
import com.example.ProductCrud.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/insertProduct")
	public String showInsertProduct(Model model) {
		return "insertProduct";
	}
	
	@PostMapping("/insertProduct")
	public ResponseEntity<String> insertProduct(@RequestBody Product p) {
		if(p!=null) {
			System.out.println(p);
		}
		else {
			System.out.println("null");
		}
		boolean status = pservice.AddProduct(p);
		if(status) {
			return ResponseEntity.ok("Data inserted successfully");
		}
		return ResponseEntity.badRequest().body("Data not inserted");
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> plist = pservice.getAll();
		if(plist!=null) {
			plist.forEach(System.out::println);
			return ResponseEntity.ok(plist);
		}
		return (ResponseEntity<List<Product>>) ResponseEntity.notFound();
	}
	
	@PutMapping("/update/{pid}")
	public ResponseEntity<String> updateProduct(@PathVariable int pid, @RequestBody Product p) {
	    p.setPid(pid);
	    boolean status = pservice.updateProduct(p);
	    if (status) {
	        return ResponseEntity.ok("Data updated successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
	    }
	}

}
