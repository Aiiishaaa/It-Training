package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "employeService")
public class EmployeService implements IEmployeService {

	@Autowired IEmployeService employeService;
	
	@Override
	public List<Employe> findAll() {
		return employeService.findAll();
	}

	@Override
	public Optional<Employe> findById(Integer id) {
		return employeService.findById(id);
	}

	@Override
	public Employe add(Employe object) {
		return employeService.add(object);
	}

	@Override
	public Employe update(Employe object) {
		return employeService.update(object);
	}

	@Override
	public void removeById(Integer id) {
		employeService.removeById(id);
	}

	@Override
	public List<Employe> findAllByRole(Integer idRole) {
		return employeService.findAllByRole(idRole);
	}

}
