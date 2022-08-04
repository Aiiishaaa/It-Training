package com.ittraining.main.dao;

import java.util.List;

import com.ittraining.main.models.Formation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FormationRepository extends JpaRepository<Formation, Integer> {
	List<Formation> findAllByThemeId(Integer idTheme);
	List<Formation> findAllByDomaineId(Integer idDomaine);
	List<Formation> findAllByEmployeId(Integer idEmploye);
	
	@Query("select f from Formation f where f.domaine.nomDomaine = ?1")
	Page<Formation> findByDomaineContaining(String domaine, Pageable pageable);
	
	@Query("select f from Formation f where f.domaine.nomDomaine = ?1")
	List<Formation> findAllByDomaine(String domaine);
	
	@Query("select f from Formation f where f.theme.nomTheme = ?1")
	List<Formation> findAllByTheme(String theme);
}
