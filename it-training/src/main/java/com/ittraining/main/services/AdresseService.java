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
		return adresseRepository.findAll();
	}

	@Override
	public Optional<Adresse> findById(Integer id) {
		return adresseRepository.findById(id);
	}

	@Override
	public Adresse add(Adresse adresse) {
		return adresseRepository.save(adresse);
	}

	@Override
	public Adresse update(Adresse adresse) {
		return adresseRepository.save(adresse);
	}

	@Override
	public void removeById(Integer id) {
		adresseRepository.deleteById(id);
	}

	@Override
	public Adresse findOneBySessionsId(Integer id) {
		return adresseRepository.findOneBySessionsId(id);
	}

}
