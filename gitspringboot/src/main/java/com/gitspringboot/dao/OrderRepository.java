package com.gitspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gitspringboot.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
