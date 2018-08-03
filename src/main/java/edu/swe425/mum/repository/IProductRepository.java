package edu.swe425.mum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.swe425.mum.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{

}
