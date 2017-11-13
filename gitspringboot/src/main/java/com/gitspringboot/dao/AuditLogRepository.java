package com.gitspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gitspringboot.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

}
