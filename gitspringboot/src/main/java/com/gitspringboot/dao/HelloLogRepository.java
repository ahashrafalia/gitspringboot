package com.gitspringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gitspringboot.model.HelloLog;

@Repository
public interface HelloLogRepository extends 
	JpaRepository<HelloLog, Integer>,
	HelloLogRepositoryCustom,
	JpaSpecificationExecutor<HelloLog>{

	List<HelloLog> findAll();
	HelloLog findByUid(Integer uid);
	List<HelloLog> findByName(String name);
}
