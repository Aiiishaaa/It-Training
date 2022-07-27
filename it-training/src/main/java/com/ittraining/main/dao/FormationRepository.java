package com.ittraining.main.dao;

import java.util.List;

import com.ittraining.main.models.Formation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Integer> {
	List<Formation> findAllByTheme(Integer idTheme);
	List<Formation> findAllByDomaine(Integer idDomaine);
	List<Formation> findAllByEmploye(Integer idEmploye);
	
}
