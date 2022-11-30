
package com.bc.service;

import java.util.List;

import com.bc.exception.AddressException;
import com.bc.exception.CustomerException;
import com.bc.exception.SessionLoginException;
import com.bc.model.Address;

public interface AddressService {

	public Address updateAddressByUserId(Address address, Integer userId, String key)
			throws AddressException, CustomerException, SessionLoginException;

	public List<Address> viewAllAddress(String key) throws AddressException, SessionLoginException;

	public Address viewAddressByUserId(Integer userId, String key) throws CustomerException, SessionLoginException;

}
