package com.ittraining.main.dao;

import java.util.List;

import com.ittraining.main.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	List<Role> findAllByEmployeId(Integer idEmploye);
}
