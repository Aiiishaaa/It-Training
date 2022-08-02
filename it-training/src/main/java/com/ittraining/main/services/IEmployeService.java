package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Employe;

public interface IEmployeService {
	List<Employe> findAll();

	Optional<Employe> findById(Integer idEmploye);

	List<Employe> findAllByRolesId(Integer idRole);

	Employe add(Employe employe);

	Employe update(Employe employe);

	void removeById(Integer id);

	Optional<Employe> findByFormationsId(Integer idFormation);
}
