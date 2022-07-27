package com.ittraining.main.dao;

import com.ittraining.main.models.Adresse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
	Adresse findOneBySessionId(Integer idSession);
}
