package com.java.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.payment.entity.Payment;
import com.java.payment.repository.PaymentInterface;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentInterface paymentRepository;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}
	
	

}
