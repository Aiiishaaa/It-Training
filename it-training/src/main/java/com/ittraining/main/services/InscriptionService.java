package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.InscriptionRepository;
import com.ittraining.main.models.Inscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "inscriptionService")
public class InscriptionService implements IInscriptionService {
	
	@Autowired
	InscriptionRepository inscriptionRepository;

	@Override
	public List<Inscription> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Inscription> findById(Integer idAdresse) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Inscription add(Inscription role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inscription update(Inscription role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
