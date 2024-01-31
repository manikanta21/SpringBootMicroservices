package com.java.test.api.controller;

import org.hibernate.type.OrderedSetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.test.api.common.TransactionRequest;
import com.java.test.api.common.TransactionResponse;
import com.java.test.api.entity.Order;
import com.java.test.api.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public ResponseEntity<TransactionResponse> bookOrder(@RequestBody TransactionRequest transactionRequest) {
		TransactionResponse transactionResponse = 
				orderService.saveOrder(transactionRequest);
		return new ResponseEntity<TransactionResponse>(transactionResponse, HttpStatus.OK);
	}

}
