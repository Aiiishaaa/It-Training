package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Role;

public interface IRoleService {

	List<Role> findAll();
	Optional<Role> findById(Integer idRole);
	Role add(Role role);
	Role update(Role role);
	void removeById(Integer id);

	List<Role> findAllByUsersId(Integer idUser);
	
}
