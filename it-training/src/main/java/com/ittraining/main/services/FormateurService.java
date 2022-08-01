package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ittraining.main.models.Formateur;

@Service(value = "formateurService")
public class FormateurService implements IFormateurService {

	@Override
	public List<Formateur> findAll() {
		return null;
	}

	@Override
	public Optional<Formateur> findById(Integer idFormateur) {
		return Optional.empty();
	}

	@Override
	public Formateur add(Formateur formateur) {
		return null;
	}

	@Override
	public Formateur update(Formateur formateur) {
		return null;
	}

	public void removeById(Integer id) {

	}

}