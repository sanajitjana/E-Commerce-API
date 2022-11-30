package com.bc.service;

import java.util.List;

import com.bc.exception.CartException;
import com.bc.exception.CustomerException;
import com.bc.exception.OrderException;
import com.bc.model.Orders;

public interface OrderService {

	public Orders addOrder(Integer cid) throws OrderException, CustomerException, CartException;

	public Orders updateOrder(Orders order) throws OrderException;

	public Orders viewOrder(Integer orderId) throws OrderException;

	public List<Orders> viewAllOrder() throws OrderException;

	public List<Orders> viewAllOrdersByUserId(Integer userId) throws OrderException;

}
