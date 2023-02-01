package io.github.alancs7.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.alancs7.hroauth.entities.User;
import io.github.alancs7.hroauth.feignclients.UserFeignClient;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.getByEmail(username).getBody();
		if (user == null) {
			log.error("Email not found " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		log.info("Email found " + username);
		return user;
	}

}
