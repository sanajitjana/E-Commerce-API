package com.os.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.exception.CartException;
import com.os.exception.CustomerException;
import com.os.exception.ProductException;
import com.os.model.Cart;
import com.os.model.Customer;
import com.os.model.Product;
import com.os.repository.CartRepo;
import com.os.repository.CustomerRepo;
import com.os.repository.ProductRepo;
import com.os.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cRepo;

	@Autowired
	private CustomerRepo crRepo;

	@Autowired
	private ProductRepo pRepo;

	@Override
	public Cart addProductToCart(Integer customerId, Integer productId)
			throws CartException, CustomerException, ProductException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		Optional<Product> itemOpt = pRepo.findById(productId);
		if (itemOpt.isEmpty())
			throw new ProductException("Product not found!");

		Customer customer = opt.get();
		Cart cart = customer.getCart();

		List<Product> itemList = cart.getProducts();
		boolean flag = true;
		for (int i = 0; i < itemList.size(); i++) {
			Product element = itemList.get(i);
			if (element.getProductId() == productId) {
				if (cart.getProduct_quantity() == null) {
					cart.setProduct_quantity(1);

				} else {
					cart.setProduct_quantity(cart.getProduct_quantity() + 1);
				}

				flag = false;
			}
		}
		if (flag) {
			cart.getProducts().add(itemOpt.get());
		}

		cRepo.save(cart);
		return cart;

	}

	@Override
	public Cart removeProductFromCart(Integer customerId, Integer productId)
			throws CartException, CustomerException, ProductException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		Optional<Product> itemOpt = pRepo.findById(productId);
		if (itemOpt.isEmpty())
			throw new ProductException("Product not found!");
		Customer customer = opt.get();
		Cart cart = customer.getCart();
		List<Product> itemList = cart.getProducts();
		boolean flag = false;
		for (int i = 0; i < itemList.size(); i++) {
			Product element = itemList.get(i);
			if (element.getProductId() == productId) {
				itemList.remove(element);
				flag = true;
				break;
			}
		}
		if (!flag) {
			throw new CartException("Product not removed from cart");
		}
		cart.setProducts(itemList);
		cRepo.save(cart);
		return cart;

	}

	@Override
	public Cart removeAllProduct(Integer customerId) throws CartException, CustomerException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");
		Cart c = opt.get().getCart();
		if (c == null) {
			throw new CartException("cart not found");
		}
		c.getProducts().clear();
		return cRepo.save(c);

	}

	@Override
	public Cart increaseProductQuantity(Integer customerId, Integer productId)
			throws CartException, CustomerException, ProductException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		Optional<Product> itemOpt = pRepo.findById(productId);
		if (itemOpt.isEmpty())
			throw new ProductException("Product not found!");

		Customer customer = opt.get();
		Cart cart = customer.getCart();
		List<Product> itemList = cart.getProducts();
		boolean flag = true;
		for (int i = 0; i < itemList.size(); i++) {
			Product element = itemList.get(i);
			if (element.getProductId() == productId) {
				cart.setProduct_quantity(cart.getProduct_quantity() + 1);
				flag = false;
			}
		}
		if (flag) {
			cart.getProducts().add(itemOpt.get());
		}

		cRepo.save(cart);
		return cart;

	}

	@Override
	public Cart decreaseProductQuantity(Integer customerId, Integer productId)
			throws CartException, CustomerException, ProductException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		Optional<Product> itemOpt = pRepo.findById(productId);
		if (itemOpt.isEmpty())
			throw new ProductException("Product not found!");

		Customer customer = opt.get();
		Cart cart = customer.getCart();
		List<Product> itemList = cart.getProducts();
		boolean flag = true;
		if (itemList.size() > 0) {
			for (int i = 0; i < itemList.size(); i++) {
				Product element = itemList.get(i);
				if (element.getProductId() == productId) {
					cart.setProduct_quantity(cart.getProduct_quantity() + 1);
					flag = false;
				}
			}
		}

		if (flag) {
			cart.getProducts().add(itemOpt.get());
		}

		cRepo.save(cart);
		return cart;
	}

}
