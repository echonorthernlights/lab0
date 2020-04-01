package com.CRUD_lab.lab0.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD_lab.lab0.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
