package io.github.alancs7.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.alancs7.hroauth.entities.User;
import io.github.alancs7.hroauth.feignclients.UserFeignClient;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;

	public User getByEmail(String email) {
		User user = userFeignClient.getByEmail(email).getBody();
		if (user == null) {
			log.error("Email not found " + email);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email not found");
		}
		log.info("Email found " + email);
		return user;
	}

}
