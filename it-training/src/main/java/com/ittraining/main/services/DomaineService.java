package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ittraining.main.dao.DomaineRepository;
import com.ittraining.main.models.Domaine;

@Service(value = "domaineService")
public class DomaineService implements IDomaineService {

	@Autowired
	private DomaineRepository domaineRepository;

	@Override
	public List<Domaine> findAll() {
		return domaineRepository.findAll();
	}

	@Override
	public Optional<Domaine> findById(Integer id) {
		return domaineRepository.findById(id);
	}

	@Override
	public Domaine add(Domaine domaine) {
		return  domaineRepository.save(domaine);
	}

	@Override
	public Domaine update(Domaine domaine) {
		return domaineRepository.save(domaine);
	}

	@Override
	public void removeById(Integer id) {
		domaineRepository.deleteById(id);
	}

	@Override
	public Domaine findByFormationsId(Integer idFormation) {
		return domaineRepository.findByFormationsId(idFormation);
	}

}