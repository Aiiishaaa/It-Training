package com.ittraining.main.dao;

import com.ittraining.main.models.Theme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
	Theme findByFormationsId(Integer idFormation);
}
