package io.github.alancs7.hruser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.alancs7.hruser.entities.User;
import io.github.alancs7.hruser.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
	}

	public User getByEmail(String email) {
		return repository.findByEmail(email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email not found"));
	}

}
