package com.gitspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gitspringboot.model.CertMaster;

public interface CertMasterRepository extends JpaRepository<CertMaster, Long>,JpaSpecificationExecutor<CertMaster> {

}
