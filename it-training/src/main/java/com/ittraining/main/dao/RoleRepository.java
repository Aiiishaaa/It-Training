package com.ittraining.main.dao;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Role;
import com.ittraining.main.models.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	List<Role> findAllByEmployesId(Integer idEmploye);
	Optional<Role> findByDesignation(RoleName designation);
}
