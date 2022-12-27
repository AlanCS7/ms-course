package io.github.alancs7.hrpayroll.services;

import org.springframework.stereotype.Service;

import io.github.alancs7.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Alan", 200.0, days);
	}
	
}
