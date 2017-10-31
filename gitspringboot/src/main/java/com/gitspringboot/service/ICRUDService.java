package com.gitspringboot.service;

import java.io.Serializable;
import java.util.List;

public interface ICRUDService<E> {
	E save(E entity);

	E getById(Serializable id);

	List<E> getAll();

	void delete(Serializable id);
}
