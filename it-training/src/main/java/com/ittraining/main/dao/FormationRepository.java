package com.ittraining.main.dao;

import java.util.List;

import com.ittraining.main.models.Formation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Integer> {
	List<Formation> findAllByThemeId(Integer idTheme);
	List<Formation> findAllByDomaineId(Integer idDomaine);
	List<Formation> findAllByEmployeId(Integer idEmploye);
	
}
