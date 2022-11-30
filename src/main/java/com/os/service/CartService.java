package com.os.service;

import com.os.exception.CartException;
import com.os.exception.CustomerException;
import com.os.exception.ProductException;
import com.os.model.Cart;

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
