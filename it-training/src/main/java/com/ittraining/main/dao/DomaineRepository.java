package com.ittraining.main.dao;

import com.ittraining.main.models.Domaine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DomaineRepository extends JpaRepository<Domaine, Integer>{
	Domaine findByFormationsId(Integer idFormation);
}
