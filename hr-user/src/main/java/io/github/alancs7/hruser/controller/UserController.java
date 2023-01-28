package io.github.alancs7.hruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.alancs7.hruser.entities.User;
import io.github.alancs7.hruser.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {

		return ResponseEntity.ok(service.getById(id));
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> getById(@RequestParam String email) {

		return ResponseEntity.ok(service.getByEmail(email));
	}
}
