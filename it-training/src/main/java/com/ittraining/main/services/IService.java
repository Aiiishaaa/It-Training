package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
	List<T> findAll();
	Optional<T> findById(Integer id);
	T add(T object);
	T update(T object);
	void removeById(Integer id);
}
