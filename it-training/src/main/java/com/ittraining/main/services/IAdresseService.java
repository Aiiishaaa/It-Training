package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Adresse;

public interface IAdresseService {

	List<Adresse> findAll();
	Optional<Adresse> findById(Integer idAdresse);
	Adresse add(Adresse role);
	Adresse update(Adresse role);
	void removeById(Integer id);
	
	Adresse findOneBySessionId(Integer idSession);
}