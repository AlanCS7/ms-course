package io.github.alancs7.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.alancs7.hrworker.entities.Worker;
import io.github.alancs7.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;

	public List<Worker> getAll() {
		return repository.findAll();
	}

	public Optional<Worker> getById(Long id) {
		return repository.findById(id);
	}

}
