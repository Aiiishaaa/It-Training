package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.RoleRepository;
import com.ittraining.main.models.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
public class RoleRestController {

	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping(value = "/roles")
	public ResponseEntity<List<Role>> findAll() {
		return new ResponseEntity<List<Role>>(roleRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/roles/{id}")
	public ResponseEntity<Optional<Role>> findById(@PathVariable Integer idRole) {
		return new ResponseEntity<Optional<Role>>(roleRepository.findById(idRole), HttpStatus.OK);
	}
	
	@PostMapping(value = "/roles")
	public ResponseEntity<Role> ajouterTheme(Role role) {
		return new ResponseEntity<Role>(roleRepository.save(role), HttpStatus.OK);
	}
	
	@PutMapping(value = "/roles/{id}")
	public ResponseEntity<Role> update(@PathVariable Integer idRole, Role role) {
		Role roleToUpdate = roleRepository.findById(idRole).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		roleToUpdate.setDesignationRole(role.getDesignationRole());
		return new ResponseEntity<Role>(roleRepository.save(roleToUpdate), HttpStatus.OK);
	}
//	
//	@DeleteMapping(value = "/roles/{id}")
//	public ResponseEntity<?> removeById(@PathVariable Integer idRole) {
//		Role roleToRemove = roleRepository.findById(idRole).orElseThrow(
//				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//		roleRepository.deleteById(roleToRemove.getIdRole());
//		return new ResponseEntity<>("Le role a bien été supprimé.", HttpStatus.OK);
//	}
	
}
