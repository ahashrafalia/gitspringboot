package com.gitspringboot.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.gitspringboot.model.CertMaster;
import com.gitspringboot.model.ClientMaster;

public interface ClientMasterService extends ICRUDService<ClientMaster>{

	public List<ClientMaster> findByClientName(Specification<ClientMaster> spec);
	public Boolean existsByclientName(String username);
}
