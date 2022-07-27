package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.AdresseRepository;
import com.ittraining.main.models.Adresse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "adresseService")
public class AdresseService implements IAdresseService {
	
	@Autowired
	AdresseRepository adresseRepository;

	@Override
	public List<Adresse> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Adresse> findById(Integer idAdresse) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Adresse add(Adresse role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse update(Adresse role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Adresse findOneBySessionId(Integer idSession) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
