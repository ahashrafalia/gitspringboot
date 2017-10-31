package com.gitspringboot.dao;

import java.util.List;

import com.gitspringboot.model.HelloLog;

public interface HelloLogRepositoryCustom {
	List<HelloLog> findByAVeryComplicatedQuery(Long id, String name);
}
