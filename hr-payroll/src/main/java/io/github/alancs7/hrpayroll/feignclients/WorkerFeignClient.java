package io.github.alancs7.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.alancs7.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> getById(@PathVariable Long id);
}
