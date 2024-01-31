package com.java.test.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.test.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
