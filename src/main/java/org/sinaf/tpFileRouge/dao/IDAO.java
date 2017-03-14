package org.sinaf.tpFileRouge.dao;

import java.util.Optional;

import org.sinaf.tpFileRouge.exception.TechniqueException;

public interface IDAO<T> {

	int create(T model) throws TechniqueException;

	void update(T model) throws TechniqueException;

	Optional<T> getById(Long id) throws TechniqueException;

	void delete(T model) throws TechniqueException;

}
