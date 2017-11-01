package com.gitspringboot.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitspringboot.dao.CustomerRepository;
import com.gitspringboot.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer entity) {

		return customerRepository.save(entity);
	}

	@Override
	public Customer getById(Serializable id) {

		return null;
	}

	@Override
	public List<Customer> getAll() {

		return customerRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {


	}

}
