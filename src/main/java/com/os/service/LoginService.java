package com.os.service;

import com.os.exception.LoginException;
import com.os.model.LoginDTO;

public interface LoginService {

	public String loginAccount(LoginDTO loginDTO) throws LoginException;

	public String logoutAccount(String role, String key) throws LoginException;

}
