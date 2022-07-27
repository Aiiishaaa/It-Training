package com.ittraining.main.services;

import java.util.List;

import com.ittraining.main.models.Role;

public interface IRoleService {

	List<Role> findAllByEmployeId(Integer idEmploye);
}
