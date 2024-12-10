package com.example.ProductCrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductCrud.beans.Product;
import com.example.ProductCrud.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService  {
	
	@Autowired
	ProductRepository prepo;

	@Override
	public boolean AddProduct(Product p) {
		if(prepo.save(p)!=null) {
			return true;
		}
		return false;
		
	}

	@Override
	public List<Product> getAll() {
		List<Product> plst = prepo.findAll();
		plst.forEach(System.out::println);
		return plst;
	}

	@Override
	public boolean updateProduct(Product p) {
	    Optional<Product> op = prepo.findById(p.getPid());
	    if (op.isPresent()) {
	        Product p2 = op.get();
	        p2.setPname(p.getPname());
	        p2.setQty(p.getQty());
	        p2.setPrice(p.getPrice());
	        p2.setExpdate(p.getExpdate());
	        p2.setCid(p.getCid());
	        prepo.save(p2);
	        return true;
	    }
	    return false;
	}
	
	

}
