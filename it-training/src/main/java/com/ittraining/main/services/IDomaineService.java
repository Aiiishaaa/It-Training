package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Domaine;

public interface IDomaineService {

	List<Domaine> findAll();

	Optional<Domaine> findById(Integer id);

	Domaine add(Domaine domaine);

	Domaine update(Domaine domaine);

	void removeById(Integer id);

	Domaine findByFormationsId(Integer idFormation);

}