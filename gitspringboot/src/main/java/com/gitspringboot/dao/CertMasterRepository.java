package com.gitspringboot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.gitspringboot.model.CertMaster;

public interface CertMasterRepository extends JpaRepository<CertMaster, Long>,JpaSpecificationExecutor<CertMaster> ,CertMasterRepositoryCustom{

	List<CertMaster> certCountClientBy90(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}
