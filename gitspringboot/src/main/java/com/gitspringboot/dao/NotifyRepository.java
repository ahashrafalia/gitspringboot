package com.gitspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gitspringboot.model.CertDetails;

public interface NotifyRepository extends JpaRepository<CertDetails, Long>,	NotifyRepositoryCustom{

}
