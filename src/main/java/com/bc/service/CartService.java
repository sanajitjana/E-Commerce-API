package com.bc.service;

import com.bc.exception.CartException;
import com.bc.exception.CustomerException;
import com.bc.exception.ProductException;
import com.bc.model.Cart;

public interface CartService {

	public Cart addProductToCart(Integer customerId, Integer productId)
			throws CartException, CustomerException, ProductException;

	public Cart removeProductFromCart(Integer customerId, Integer productId)
			throws CartException, CustomerException, ProductException;

	public Cart removeAllProduct(Integer customerId) throws CartException, CustomerException;

	public Cart increaseProductQuantity(Integer customerId, Integer productId)
			throws CartException, CustomerException, ProductException;

	public Cart decreaseProductQuantity(Integer customerId, Integer productId)
			throws CartException, CustomerException, ProductException;

}
