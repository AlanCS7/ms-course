package io.github.alancs7.hrworker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.alancs7.hrworker.entities.Worker;
import io.github.alancs7.hrworker.services.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	@Autowired
	private WorkerService service;

	@GetMapping
	public ResponseEntity getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Worker getById(@PathVariable Long id) {

		return service.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
