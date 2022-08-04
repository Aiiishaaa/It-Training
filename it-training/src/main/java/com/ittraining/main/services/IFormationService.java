package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Formation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFormationService {
	
	List<Formation> findAll();
	Optional<Formation> findById(Integer idFormation);
	List<Formation> findAllByThemeId(Integer idTheme);
	List<Formation> findAllByDomaineId(Integer idDomaine);
	List<Formation> findAllByUserId(Integer idUser);
	Formation add(Formation formation);
	Formation update(Formation formation);
	void removeById(Integer id);
	
	List<Formation> findAllByDomaine(String domaine);
	Page<Formation> findByDomaineContaining(String domaine, Pageable pageable);
	
	List<Formation> findAllByTheme(String theme);

}
