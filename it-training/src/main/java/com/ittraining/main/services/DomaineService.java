package com.ittraining.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ittraining.main.models.Domaine;

@Service(value = "domaineService")

public class DomaineService implements IDomaineService {

	@Override
	public List<Domaine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}