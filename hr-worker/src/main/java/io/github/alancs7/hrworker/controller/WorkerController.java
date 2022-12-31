package io.github.alancs7.hrworker.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.alancs7.hrworker.entities.Worker;
import io.github.alancs7.hrworker.services.WorkerService;	

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerController {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;

	@Autowired
	private WorkerService service;


	@GetMapping("/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}

	
	@GetMapping
	public ResponseEntity<List<Worker>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> getById(@PathVariable Long id) {
		
		logger.info("PORT = " + env.getProperty("local.server.port"));

		Optional<Worker> worker = service.getById(id);
		
		return worker.isPresent() ? 
				ResponseEntity.ok(worker.get()) :
				ResponseEntity.notFound().build();
	}
}
