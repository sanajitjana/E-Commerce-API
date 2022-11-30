package com.os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.os.exception.CartException;
import com.os.exception.CustomerException;
import com.os.exception.ProductException;
import com.os.model.Cart;
import com.os.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cService;

	@PostMapping("/add")
	public ResponseEntity<Cart> addProductToCart(@RequestParam("customerId") Integer cId,
			@RequestParam("productId") Integer productId) throws CartException, CustomerException, ProductException {
		return new ResponseEntity<Cart>(cService.addProductToCart(cId, productId), HttpStatus.OK);

	}

	@DeleteMapping("/remove/{cartId}/{productId}")
	public ResponseEntity<Cart> removeProductFromCart(@PathVariable("cartId") Integer cartId,
			@PathVariable("productId") Integer productId) throws CartException, CustomerException, ProductException {
		return new ResponseEntity<Cart>(cService.removeProductFromCart(cartId, productId), HttpStatus.OK);
	}

	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<Cart> removeAllProduct(@PathVariable("cartId") Integer cartId)
			throws CartException, CustomerException {
		return new ResponseEntity<Cart>(cService.removeAllProduct(cartId), HttpStatus.OK);
	}

	@PutMapping("/increase/{cartId}/{productId}")
	public ResponseEntity<Cart> increaseProductQuantity(@PathVariable("cartId") Integer cartId,
			@PathVariable("productId") Integer productId) throws CartException, CustomerException, ProductException {
		return new ResponseEntity<Cart>(cService.increaseProductQuantity(cartId, productId), HttpStatus.OK);
	}

	@PutMapping("/decrease/{cartId}/{productId}")
	public ResponseEntity<Cart> decreaseProductQuantity(@PathVariable("cartId") Integer cartId,
			@PathVariable("productId") Integer productId) throws CartException, CustomerException, ProductException {
		return new ResponseEntity<Cart>(cService.decreaseProductQuantity(cartId, productId), HttpStatus.OK);
	}
}
