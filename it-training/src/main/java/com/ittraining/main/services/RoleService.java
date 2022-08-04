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
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> findById(Integer id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

	@Override
	public Role add(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public Role update(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void removeById(Integer id) {
		roleRepository.deleteById(id);
	}

	@Override
	public List<Role> findAllByUsersId(Integer id) {
		return roleRepository.findAllByUsersId(id);
	}

}
