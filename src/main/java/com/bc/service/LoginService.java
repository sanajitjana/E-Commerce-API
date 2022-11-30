package com.bc.service;

import com.bc.exception.LoginException;
import com.bc.model.LoginDTO;

public interface LoginService {

	public String loginAccount(LoginDTO loginDTO) throws LoginException;

	public String logoutAccount(String role, String key) throws LoginException;

}
