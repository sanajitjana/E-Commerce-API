package com.bc.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bc.exception.AddressException;
import com.bc.exception.CustomerException;
import com.bc.exception.SessionLoginException;
import com.bc.model.Address;
import com.bc.model.Customer;
import com.bc.repository.AddressRepo;
import com.bc.repository.CustomerRepo;
import com.bc.service.AddressService;
import com.bc.service.SessionLoginService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private SessionLoginService sessionService;

	// check customer is available or not in database
	public Customer userValidation(Integer userId) throws CustomerException {
		Optional<Customer> customerOpt = customerRepo.findById(userId);
		if (customerOpt.isEmpty())
			throw new CustomerException("Customer not found with this id " + userId);
		return customerOpt.get();
	}

	@Override
	public Address updateAddressByUserId(Address address, Integer userId, String key)
			throws AddressException, CustomerException, SessionLoginException {
		if (address == null)
			throw new AddressException("Address can't be null");

		// checking user login status
		sessionService.checkAnyUserLoginStatus(key);

		Customer customer = userValidation(userId);
		customer.setAddress(address);
		customerRepo.save(customer);
		return address;
	}

	@Override
	public List<Address> viewAllAddress(String key) throws AddressException, SessionLoginException {

		// checking user login status
		sessionService.checkAnyUserLoginStatus(key);

		List<Address> addresses = addressRepo.findAll();
		if (addresses.isEmpty())
			throw new AddressException("Address list is empty!");
		return addresses;
	}

	@Override
	public Address viewAddressByUserId(Integer userId, String key) throws CustomerException, SessionLoginException {

		// checking user login status
		sessionService.checkAnyUserLoginStatus(key);

		Customer customer = userValidation(userId);
		return customer.getAddress();
	}

}
