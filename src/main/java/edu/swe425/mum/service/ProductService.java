package edu.swe425.mum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swe425.mum.model.Product;
import edu.swe425.mum.repository.IProductRepository;

@Service("productService")
public class ProductService {
	
	@Autowired
	IProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Product findById(Long productId) {
		Optional<Product> op = productRepository.findById(productId);
		return op.orElse(null);
	}

	public void delete(Long productId) {
		productRepository.deleteById(productId);
	}
	
	
}
