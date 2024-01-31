package com.java.test.api.common;

import com.java.test.api.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

	public TransactionResponse(Order order2, double amount2, String transactionId2, String response) {
		this.order = order2;
		this.amount = amount2;
		this.transactionId = transactionId2;
		this.message = response;
	}
	private Order order;
	private double amount;
	private String transactionId;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
}
