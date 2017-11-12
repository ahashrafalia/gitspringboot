package com.gitspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gitspringboot.model.CertDetails;

public interface CertStatusRepository extends JpaRepository<CertDetails, Long>,CertStatusRepositoryCustom {

}
