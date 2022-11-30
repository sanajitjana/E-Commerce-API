package com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.os.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
