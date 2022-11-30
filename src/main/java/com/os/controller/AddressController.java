package com.os.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.os.exception.AddressException;
import com.os.exception.CustomerException;
import com.os.exception.SessionLoginException;
import com.os.model.Address;
import com.os.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PutMapping("/update/{userId}")
	public ResponseEntity<Address> updateAddressByUserId(@PathVariable("userId") Integer userId,
			@RequestBody Address address, @RequestParam("key") String key)
			throws AddressException, CustomerException, SessionLoginException {
		return new ResponseEntity<Address>(addressService.updateAddressByUserId(address, userId, key), HttpStatus.OK);
	}

	@GetMapping("/view")
	public ResponseEntity<List<Address>> viewAllAddress(@RequestParam("key") String key)
			throws AddressException, SessionLoginException {
		return new ResponseEntity<List<Address>>(addressService.viewAllAddress(key), HttpStatus.OK);
	}

	@GetMapping("/view/{userId}")
	public ResponseEntity<Address> viewAddressByUserId(@RequestParam("key") String key,
			@PathVariable("userId") Integer userId) throws CustomerException, SessionLoginException {
		return new ResponseEntity<Address>(addressService.viewAddressByUserId(userId, key), HttpStatus.OK);
	}
}
