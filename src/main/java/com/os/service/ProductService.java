package com.os.service;

import java.util.List;

import com.os.exception.ProductException;
import com.os.model.Product;

public interface ProductService {

	public List<Product> viewAllProduct() throws ProductException;

	public Product addProduct(Product product) throws ProductException;

	public Product updateProduct(Product product) throws ProductException;

	public Product viewProduct(Integer productId) throws ProductException;

	public List<Product> viewProductByCategory(Integer categoryId) throws ProductException;

	public Product removeProduct(Integer productId) throws ProductException;

}
