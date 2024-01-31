package com.java.test.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.test.api.common.Payment;
import com.java.test.api.common.TransactionRequest;
import com.java.test.api.common.TransactionResponse;
import com.java.test.api.entity.Order;
import com.java.test.api.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		String response = "";
		Order order = transactionRequest.getOrder();
		Payment payment = transactionRequest.getPayment();
		
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		response = paymentResponse.getPaymentStatus().equalsIgnoreCase("success")?"payment processing successfull and order placed":"there is a failure in payment api order added to cart";
		
	    orderRepository.save(order);
	    
	    return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
	}

}
