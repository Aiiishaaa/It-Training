package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Employe;
import com.ittraining.main.services.IEmployeService;
import com.ittraining.main.services.IFormationService;
import com.ittraining.main.services.IRoleService;

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
public class EmployeRestController {

	@Autowired
	private IEmployeService employeService;

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IFormationService formationService;

	@GetMapping(value = "/employes")
	public ResponseEntity<List<Employe>> recupererEmployes() {
		return new ResponseEntity<List<Employe>>(employeService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/employes/{id}")
	public ResponseEntity<Optional<Employe>> recupererEmployeParId(@PathVariable("id") Integer idEmploye) {
		employeService.findById(idEmploye).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employe non trouvé avec Id " + idEmploye));
		return new ResponseEntity<Optional<Employe>>(employeService.findById(idEmploye), HttpStatus.OK);
	}

	@GetMapping(value = "/roles/{id}/employes")
	public ResponseEntity<List<Employe>> recupererEmployeParRole(@PathVariable("id") Integer idRole) {
		roleService.findById(idRole).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rôle non trouvé avec Id " + idRole));
		List<Employe> employesParRole = employeService.findAllByRolesId(idRole);
		return new ResponseEntity<>(employesParRole, HttpStatus.OK);
	}
	
	@GetMapping(value = "/formations/{id}/employes")
	public ResponseEntity<Optional<Employe>> recupererEmployeParFormation(@PathVariable("id") Integer idFormation) {
		formationService.findById(idFormation).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Formation non trouvé avec Id " + idFormation));
		Optional<Employe> employe = employeService.findByFormationsId(idFormation);
		return new ResponseEntity<Optional<Employe>>(employe, HttpStatus.OK);
	}

	@PostMapping(value = "/employes")
	public ResponseEntity<Employe> ajouterEmploye(@RequestBody Employe employe) {
		return new ResponseEntity<Employe>(employeService.add(employe), HttpStatus.OK);
	}

	@PutMapping(value = "/employes/{id}")
	public ResponseEntity<Employe> modifierEmploye(@PathVariable("id") Integer idEmploye,
			@RequestBody Employe employe) {
		Employe employeACorriger = employeService.findById(idEmploye).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employe non trouvé avec Id " + idEmploye));
		employeACorriger.setEmailEmploye(employe.getEmailEmploye());
		employeACorriger.setRoles(employeACorriger.getRoles());
		employeACorriger.setNomEmploye(employe.getNomEmploye());
		employeACorriger.setPasswordEmploye(employe.getPasswordEmploye());
		employeACorriger.setPrenomEmploye(employe.getPrenomEmploye());
		return new ResponseEntity<Employe>(employeService.update(employeACorriger), HttpStatus.OK);
	}

	@DeleteMapping(value = "/employes/{id}")
	public ResponseEntity<?> supprimerEmploye(@PathVariable("id") Integer idEmploye) {
		Employe employeASupprimer = employeService.findById(idEmploye).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employe non trouvé avec Id " + idEmploye));
		employeService.removeById(employeASupprimer.getId());
		return new ResponseEntity<>("L'employé a bien été supprimé.", HttpStatus.OK);
	}
}
