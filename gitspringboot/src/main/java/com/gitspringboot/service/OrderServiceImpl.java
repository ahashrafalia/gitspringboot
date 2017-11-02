package com.gitspringboot.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitspringboot.dao.OrderRepository;
import com.gitspringboot.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Order save(Order entity) {
		return orderRepository.save(entity);

	}

	@Override
	public Order getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

}
