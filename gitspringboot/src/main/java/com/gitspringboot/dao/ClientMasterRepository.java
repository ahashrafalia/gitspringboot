package com.gitspringboot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.gitspringboot.model.CertMaster;
import com.gitspringboot.model.ClientMaster;

@Repository
public interface ClientMasterRepository extends JpaRepository<ClientMaster, Long>,JpaSpecificationExecutor<ClientMaster> {

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM ClientMaster u WHERE u.clientName = ?1")
    public Boolean existsByclientName(String username);
	
}
