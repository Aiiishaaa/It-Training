package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.ThemeRepository;
import com.ittraining.main.models.Theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "themeService")
public class ThemeService implements IThemeService {

	@Autowired
	private ThemeRepository themeRepository;

	@Override
	public List<Theme> findAll() {
		return themeRepository.findAll();
	}

	@Override
	public Optional<Theme> findById(Integer id) {
		return themeRepository.findById(id);
	}

	@Override
	public Theme add(Theme theme) {
		return themeRepository.save(theme);
	}

	@Override
	public Theme update(Theme theme) {
		return themeRepository.save(theme);
	}

	@Override
	public void removeById(Integer id) {
		themeRepository.deleteById(id);
	}
	
	
}