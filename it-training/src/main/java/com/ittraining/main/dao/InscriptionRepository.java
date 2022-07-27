package com.ittraining.main.dao;

import com.ittraining.main.models.Inscription;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

}
