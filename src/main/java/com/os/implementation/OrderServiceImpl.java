package com.os.implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.exception.CartException;
import com.os.exception.CustomerException;
import com.os.exception.OrderException;
import com.os.model.Cart;
import com.os.model.Customer;
import com.os.model.Orders;
import com.os.repository.CustomerRepo;
import com.os.repository.OrderRepo;
import com.os.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo oRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Orders addOrder(Integer cid) throws OrderException, CustomerException, CartException {

		Optional<Customer> opt = customerRepo.findById(cid);
		if (opt.isEmpty()) {
			throw new CustomerException("Customer not found");
		}

		Customer c = opt.get();
		Cart cart = c.getCart();
		Orders o = new Orders();

		o.setDate(LocalDateTime.now());
		o.setOrderStatus("Pending");
		o.setAddress(c.getAddress());
		o.setCustomer(c);
		if (cart.getProducts().isEmpty()) {
			throw new CartException("add minimum one product to order!");
		} else {
			o.setProductList(new ArrayList<>(cart.getProducts()));
			return oRepo.save(o);
		}

	}

	@Override
	public Orders updateOrder(Orders order) throws OrderException {
		Orders o = oRepo.findById(order.getOrderId()).orElseThrow(() -> new OrderException("Order not found"));
		if (o != null) {
			oRepo.save(order);
		}
		return o;
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {
		Optional<Orders> o = oRepo.findById(orderId);
		if (o.isPresent()) {
			return o.get();
		} else {
			throw new OrderException("order not present!!");
		}

	}

	@Override
	public List<Orders> viewAllOrder() throws OrderException {
		List<Orders> orders = oRepo.findAll();
		if (orders.size() > 0) {
			return orders;
		} else {
			throw new OrderException("Order not found");
		}
	}

	@Override
	public List<Orders> viewAllOrdersByUserId(Integer uderId) throws OrderException {
		List<Orders> orders = customerRepo.getAllOrderByCid(uderId);
		if (orders.size() > 0) {
			return orders;
		} else {
			throw new OrderException("Order not found");
		}
	}

}
