package com.hombre.security;

import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//prototyp - jen na ukázku -> při každém zavolání se vytvoří nové entita
@Scope("prototype")
public class HashCode {

	public String getHashPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		return hashedPassword;
	}
}
