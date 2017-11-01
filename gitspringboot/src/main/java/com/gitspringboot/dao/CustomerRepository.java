package com.gitspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gitspringboot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
