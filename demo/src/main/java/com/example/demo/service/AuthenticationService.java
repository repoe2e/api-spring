package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	
	//dados de segurança
	private static final String USERNAME = "e2etreinamentos";
	private static final String PASSWORD = "e2e@123";

	public boolean isAuthenticated(String username, String password) {
		// Verifica se o usuário e a senha correspondem às credenciais esperadas
		return USERNAME.equals(username) && PASSWORD.equals(password);
	}
}
