package com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.os.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {

}
