package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

//import com.ittraining.main.dao.ThemeRepository;
//import com.ittraining.main.dao.DomaineRepository;
//import com.ittraining.main.dao.EmployeRepository;
import com.ittraining.main.dao.FormationRepository;

import com.ittraining.main.models.Formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service(value = "formationService")
public class FormationService implements IFormationService {

	@Autowired
	private FormationRepository formationRepository;

	@Override
	public List<Formation> findAll() {
		return formationRepository.findAll();
	}

	@Override
	public Optional<Formation> findById(Integer id) {
		return formationRepository.findById(id);
	}

	@Override
	public Formation add(Formation formation) {
		return formationRepository.save(formation);
	}

	@Override
	public Formation update(Formation formation) {
		return formationRepository.save(formation);
	}

	@Override
	public void removeById(Integer id) {
		formationRepository.deleteById(id);
	}

	@Override
	public List<Formation> findAllByThemeId(Integer idTheme) {
		return formationRepository.findAllByThemeId(idTheme);
	}

	@Override
	public List<Formation> findAllByDomaineId(Integer idDomaine) {
		return formationRepository.findAllByDomaineId(idDomaine);
	}

	@Override
	public List<Formation> findAllByUserId(Integer idUser) {
		return formationRepository.findAllByUserId(idUser);
	}

	@Override
	public Page<Formation> findByDomaineContaining(String domaine, Pageable pageable) {
		return formationRepository.findByDomaineContaining(domaine, pageable);
	}

	@Override
	public List<Formation> findAllByDomaine(String domaine) {
		return formationRepository.findAllByDomaine(domaine);
	}

	@Override
	public List<Formation> findAllByTheme(String theme) {
		return formationRepository.findAllByTheme(theme);
	}

}
