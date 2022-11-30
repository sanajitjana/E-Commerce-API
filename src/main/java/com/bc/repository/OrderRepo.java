package com.bc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bc.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {

}
