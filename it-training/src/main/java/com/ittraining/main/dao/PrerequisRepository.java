package com.ittraining.main.dao;

import java.util.Optional;

import com.ittraining.main.models.Prerequis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrerequisRepository extends JpaRepository<Prerequis, Integer> {
	Optional<Prerequis> findOneByFormationId(Integer idFormation);
}
