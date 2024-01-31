package com.java.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.payment.entity.Payment;

public interface PaymentInterface extends JpaRepository<Payment, Integer> {

}
