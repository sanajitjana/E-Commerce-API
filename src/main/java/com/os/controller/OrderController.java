package com.os.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.os.exception.CartException;
import com.os.exception.CustomerException;
import com.os.exception.OrderException;
import com.os.model.Orders;
import com.os.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService oService;

	@PostMapping("/add")
	public ResponseEntity<Orders> addOrder(@RequestParam("customerId") Integer customerId)
			throws OrderException, CustomerException, CartException {
		return new ResponseEntity<Orders>(oService.addOrder(customerId), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) throws OrderException {
		return new ResponseEntity<Orders>(oService.updateOrder(order), HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Orders> viewOrderById(@PathVariable("id") Integer orderId) throws OrderException {
		return new ResponseEntity<Orders>(oService.viewOrder(orderId), HttpStatus.OK);
	}

	@GetMapping("/view")
	public ResponseEntity<List<Orders>> viewAllOrder() throws OrderException {
		return new ResponseEntity<List<Orders>>(oService.viewAllOrder(), HttpStatus.OK);
	}

	@GetMapping("/view/{userId}")
	public ResponseEntity<List<Orders>> viewOrderByUserId(@PathVariable("userId") Integer userId)
			throws OrderException {
		return new ResponseEntity<List<Orders>>(oService.viewAllOrdersByUserId(userId), HttpStatus.OK);
	}
}
