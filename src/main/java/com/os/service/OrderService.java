package com.os.service;

import java.util.List;

import com.os.exception.CartException;
import com.os.exception.CustomerException;
import com.os.exception.OrderException;
import com.os.model.Orders;

public interface OrderService {

	public Orders addOrder(Integer cid) throws OrderException, CustomerException, CartException;

	public Orders updateOrder(Orders order) throws OrderException;

	public Orders viewOrder(Integer orderId) throws OrderException;

	public List<Orders> viewAllOrder() throws OrderException;

	public List<Orders> viewAllOrdersByUserId(Integer userId) throws OrderException;

}
