package com.gitspringboot.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.gitspringboot.model.CertMaster;

public interface CertMasterService extends ICRUDService<CertMaster> {

	public List<CertMaster> findBySearch(Specification<CertMaster> spec);
}
