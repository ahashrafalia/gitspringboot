package com.gitspringboot.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gitspringboot.dao.ClientMasterRepository;
import com.gitspringboot.model.CertMaster;
import com.gitspringboot.model.ClientMaster;

@Service
public class ClientMasterServiceImpl implements ClientMasterService {

	@Autowired
	ClientMasterRepository clientMasterRepository;
	
	@Override
	public ClientMaster save(ClientMaster entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientMaster getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientMaster> getAll() {
		List<ClientMaster> list= clientMasterRepository.findAll();
		return list;
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ClientMaster> findByClientName(Specification<ClientMaster> spec) {
		// TODO Auto-generated method stub
		return clientMasterRepository.findAll(spec);
	}

	

}
