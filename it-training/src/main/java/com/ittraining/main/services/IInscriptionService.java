package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Inscription;

public interface IInscriptionService {

	List<Inscription> findAll();
	Optional<Inscription> findById(Integer idAdresse);
	Inscription add(Inscription role);
	Inscription update(Inscription role);
	void removeById(Integer id);
}
