package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.RoleRepository;
import com.ittraining.main.models.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleService implements IRoleService{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Role> findById(Integer idRole) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Role add(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role update(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> findAllByEmployeId(Integer idEmploye) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
