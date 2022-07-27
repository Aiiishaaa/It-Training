package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "themeService")
public class ThemeService implements IThemeService {
	
	@Autowired
	private IThemeService themeService;

	@Override
	public List<Theme> findAll() {
		return themeService.findAll();
	}

	@Override
	public Optional<Theme> findById(Integer id) {
		return themeService.findById(id);
	}

	@Override
	public Theme add(Theme object) {
		return themeService.add(object);
	}

	@Override
	public Theme update(Theme object) {
		return themeService.update(object);
	}

	@Override
	public void removeById(Integer id) {
		themeService.removeById(id);
		
	}

}
