package com.os.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.exception.CustomerException;
import com.os.model.Customer;
import com.os.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService cService;

	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) throws CustomerException {
		return new ResponseEntity<Customer>(cService.addCustomer(c), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) throws CustomerException {
		return new ResponseEntity<Customer>(cService.updateCustomer(c), HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Customer> removeCustomerById(@PathVariable("id") Integer customerId) throws CustomerException {
		return new ResponseEntity<Customer>(cService.remove(customerId), HttpStatus.OK);
	}

	@GetMapping("/view")
	public ResponseEntity<List<Customer>> viewAllCustomer() throws CustomerException {
		return new ResponseEntity<List<Customer>>(cService.viewAllCustomer(), HttpStatus.OK);
	}

}
