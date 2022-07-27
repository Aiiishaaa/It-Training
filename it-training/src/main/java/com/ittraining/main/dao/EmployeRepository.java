package com.ittraining.main.dao;

import java.util.List;

import com.ittraining.main.models.Employe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer>{
	List<Employe> findAllByRoleId(Integer idRole);
}
