package com.os.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.exception.SessionLoginException;
import com.os.model.CurrentUserSession;
import com.os.repository.CurrentUserSessionRepo;
import com.os.service.SessionLoginService;

@Service
public class SessionLoginServiceImpl implements SessionLoginService {

	@Autowired
	private CurrentUserSessionRepo sessionRepo;

	@Override
	public void checkAnyUserLoginStatus(String key) throws SessionLoginException {
		CurrentUserSession currSess = sessionRepo.findByPrivateKey(key);
		if (currSess == null)
			throw new SessionLoginException("User login required");
	}

	@Override
	public void checkAdminUserLoginStatus(String key) throws SessionLoginException {
		CurrentUserSession currSess = sessionRepo.findByPrivateKey(key);
		if (currSess != null && !currSess.getRole().equalsIgnoreCase("admin"))
			throw new SessionLoginException("Admin login required");
	}

	@Override
	public void checkCustomerUserLoginStatus(String key) throws SessionLoginException {
		CurrentUserSession currSess = sessionRepo.findByPrivateKey(key);
		if (currSess != null && !currSess.getRole().equalsIgnoreCase("customer"))
			throw new SessionLoginException("Admin login required");
	}

}
