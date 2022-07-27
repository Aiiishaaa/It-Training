package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Formateur;

public interface IFormateurService {

	
	List<Formateur> findAll();
	Optional<Formateur> findById(Integer idFormateur);
	Formateur add(Formateur formateur);
	Formateur update(Formateur formateur);
	void removeById(Integer id);

}
