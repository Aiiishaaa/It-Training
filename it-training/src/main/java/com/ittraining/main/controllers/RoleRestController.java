package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Role;
import com.ittraining.main.services.IRoleService;
import com.ittraining.main.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
public class RoleRestController {

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/roles")
	public ResponseEntity<List<Role>> recupererRoles() {
		return new ResponseEntity<List<Role>>(roleService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/roles/{id}")
	public ResponseEntity<Optional<Role>> recupererRoleParId(@PathVariable("id") Integer idRole) {
		return new ResponseEntity<Optional<Role>>(roleService.findById(idRole), HttpStatus.OK);
	}
	
	@PostMapping(value = "/roles")
	public ResponseEntity<Role> ajouterRole(@RequestBody Role role) {
		return new ResponseEntity<Role>(roleService.add(role), HttpStatus.OK);
	}
	
//	@PutMapping(value = "/roles/{id}")
//	public ResponseEntity<Role> modifierRole(@PathVariable("id") Integer idRole, @RequestBody Role role) {
//		Role roleToUpdate = roleService.findById(idRole).orElseThrow(
//				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role non trouvé avec Id " + idRole));
//		roleToUpdate.setDesignationRole(role.getDesignationRole());
//		return new ResponseEntity<Role>(roleService.update(roleToUpdate), HttpStatus.OK);
//	}
	
	@DeleteMapping(value = "/roles/{id}")
	public ResponseEntity<?> supprimerRole(@PathVariable("id") Integer idRole) {
		Role roleToRemove = roleService.findById(idRole).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role non trouvé avec Id " + idRole));
		roleService.removeById(roleToRemove.getId());
		return new ResponseEntity<>("Le role a bien été supprimé.", HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{id}/roles")
	public ResponseEntity<List<Role>> findAllByUsersId(@PathVariable("id") Integer id) {
		userService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + id));
		List<Role> roles = roleService.findAllByUsersId(id);
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
}
