package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Formation;

public interface IFormationService {
	List<Formation> findAll();
	Optional<Formation> findById(Integer idFormation);
	List<Formation> findAllByTheme(Integer idTheme);
	List<Formation> findAllByDomaine(Integer idDomaine);
	List<Formation> findAllByEmploye(Integer idEmploye);
	Formation add(Formation formation);
	Formation update(Formation formation);
	void removeById(Integer id);
}
