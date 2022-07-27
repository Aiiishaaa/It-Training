package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.EmployeRepository;
import com.ittraining.main.models.Employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "employeService")
public class EmployeService implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	@Override
	public List<Employe> findAll() {
		return employeRepository.findAll();
	}

	@Override
	public Optional<Employe> findById(Integer idEmploye) {
		return employeRepository.findById(idEmploye);
	}

	@Override
	public Employe add(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public Employe update(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public void removeById(Integer idEmploye) {
		employeRepository.deleteById(idEmploye);
	}

	@Override
	public List<Employe> findAllByRoleId(Integer idRole) {
		return employeRepository.findAllByRoleId(idRole);
	}

}
