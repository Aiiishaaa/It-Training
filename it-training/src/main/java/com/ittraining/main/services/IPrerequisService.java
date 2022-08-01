package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Prerequis;

public interface IPrerequisService {

	List<Prerequis> findAll();

	Optional<Prerequis> findById(Integer id);

	Prerequis add(Prerequis object);

	Prerequis update(Prerequis object);

	void removeById(Integer id);
}
