package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

//import com.ittraining.main.dao.ThemeRepository;
//import com.ittraining.main.dao.DomaineRepository;
//import com.ittraining.main.dao.EmployeRepository;
import com.ittraining.main.dao.FormationRepository;

import com.ittraining.main.models.Formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "formationService")
public class FormationService implements IFormationService {
	
	@Autowired
	private FormationRepository formationRepository;
	
//	@Autowired
//	private ThemeRepository themeRepository;
//
//	@Autowired
//	private DomaineRepository domaineRepository;
//	
//	@Autowired
//	private EmployeRepository employeRepository;
	
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
	public List<Formation> findAllByTheme(Integer idTheme) {
		return formationRepository.findAllByTheme(idTheme);
	}

	@Override
	public List<Formation> findAllByDomaine(Integer idDomaine) {
		return formationRepository.findAllByDomaine(idDomaine);
	}

	@Override
	public List<Formation> findAllByEmploye(Integer idEmploye) {
		return formationRepository.findAllByEmploye(idEmploye);
	}

	
}
