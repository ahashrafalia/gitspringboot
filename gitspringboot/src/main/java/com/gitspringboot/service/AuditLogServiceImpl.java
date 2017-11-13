package com.gitspringboot.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitspringboot.dao.AuditLogRepository;
import com.gitspringboot.model.AuditLog;

@Service
public class AuditLogServiceImpl implements AuditLogService {

	@Autowired
	AuditLogRepository auditLogRepository;
	
	@Override
	public AuditLog save(AuditLog entity) {
		
		return auditLogRepository.save(entity);
	}

	@Override
	public AuditLog getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuditLog> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

}
