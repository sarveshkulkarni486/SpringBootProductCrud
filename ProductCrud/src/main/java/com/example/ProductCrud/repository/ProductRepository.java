package com.example.ProductCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductCrud.beans.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
