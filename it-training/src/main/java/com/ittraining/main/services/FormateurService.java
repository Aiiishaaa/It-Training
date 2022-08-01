package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ittraining.main.dao.FormateurRepository;
import com.ittraining.main.models.Formateur;

@Service(value = "formateurService")
public class FormateurService implements IFormateurService {

	
	@Autowired
	private FormateurRepository formateurRepository;
	
	
	@Override
	public List<Formateur> findAll() {
		return formateurRepository.findAll();
	}

	@Override
	public Optional<Formateur> findById(Integer id) {
		return formateurRepository.findById(id);
	}

	@Override
	public Formateur add(Formateur formateur) {
		 return formateurRepository.save(formateur);
	}

	@Override
	public Formateur update(Formateur formateur) {
		return formateurRepository.save(formateur);
	}

	public void removeById(Integer id) {
		formateurRepository.deleteById(id);
	}

}