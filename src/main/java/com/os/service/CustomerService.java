package com.os.service;

import java.util.List;

import com.os.exception.CustomerException;
import com.os.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(Customer customer) throws CustomerException;

	public Customer remove(Integer customerId) throws CustomerException;

	public List<Customer> viewAllCustomer() throws CustomerException;

}
