package com.os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.os.exception.LoginException;
import com.os.model.LoginDTO;
import com.os.service.LoginService;

@RestController
@RequestMapping("/app")
public class LoginLogoutController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<String> logIn(@RequestBody LoginDTO loginDTO) throws LoginException {
		return new ResponseEntity<String>(loginService.loginAccount(loginDTO), HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestParam(required = false) String role,
			@RequestParam(required = false) String key) throws LoginException {
		return new ResponseEntity<String>(loginService.logoutAccount(role, key), HttpStatus.OK);
	}

}
