package com.gitspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gitspringboot.model.ClientMaster;

@Repository
public interface ClientMasterRepository extends JpaRepository<ClientMaster, Long> {

}
