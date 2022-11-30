package com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.os.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
