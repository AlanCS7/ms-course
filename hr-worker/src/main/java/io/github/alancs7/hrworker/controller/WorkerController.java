package io.github.alancs7.hrworker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.alancs7.hrworker.entities.Worker;
import io.github.alancs7.hrworker.services.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	@Autowired
	private WorkerService service;

	@GetMapping
	public ResponseEntity<List<Worker>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> getById(@PathVariable Long id) {

		Optional<Worker> worker = service.getById(id);
		
		return worker.isPresent() ? 
				ResponseEntity.ok(worker.get()) :
				ResponseEntity.notFound().build();
	}
}
