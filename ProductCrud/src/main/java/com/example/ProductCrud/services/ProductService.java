package com.example.ProductCrud.services;

import java.util.List;

import com.example.ProductCrud.beans.Product;

public interface ProductService {

	boolean AddProduct(Product p);

	List<Product> getAll();

	boolean updateProduct(Product p);

}
