package com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.os.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}
