package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Theme;

public interface IThemeService {
	List<Theme> findAll();

	Optional<Theme> findById(Integer id);

	Theme add(Theme object);

	Theme update(Theme object);

	void removeById(Integer id);

	Theme findByFormationsId(Integer idFormation);
}