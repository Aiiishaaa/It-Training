package com.ittraining.main.dao;

import java.util.List;

import com.ittraining.main.models.Theme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
	List<Theme> findAllByDomaineId(Integer idDomaine);
}
