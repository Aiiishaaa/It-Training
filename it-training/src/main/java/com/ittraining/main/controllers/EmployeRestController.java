package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.EmployeRepository;
import com.ittraining.main.models.Employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
public class EmployeRestController {
	
	@Autowired
	private EmployeRepository employeRepository;
	
	@GetMapping(value = "/employes")
	public ResponseEntity<List<Employe>> recupererEmployes() {
		return new ResponseEntity<List<Employe>>(employeRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/employes/{id}")
	public ResponseEntity<Optional<Employe>> recupererEmployeParId(@PathVariable Integer idEmploye) {
		return new ResponseEntity<Optional<Employe>>(employeRepository.findById(idEmploye), HttpStatus.OK);
	}
	
	@GetMapping(value = "/roles/{idRole}/employes")
	public ResponseEntity<List<Employe>> recupererEmployeParRole(@PathVariable Integer idRole) {
		return new ResponseEntity<List<Employe>>(employeRepository.findAllByRole(idRole), HttpStatus.OK);
	}
	
	@PostMapping(value = "/employes")
	public ResponseEntity<Employe> ajouterEmploye(Employe employe) {
		return new ResponseEntity<Employe>(employeRepository.save(employe), HttpStatus.OK);
	}
	
	@PutMapping(value = "/employes/{id}")
	public ResponseEntity<Employe> modifierEmploye(@PathVariable Integer idEmploye, Employe employe) {
		Employe employeACorriger = employeRepository.findById(idEmploye).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		employeACorriger.setEmailEmploye(employe.getEmailEmploye());
//		employeACorriger.setRoles(employeACorriger.getRoles());
		employeACorriger.setNomEmploye(employe.getNomEmploye());
		employeACorriger.setPasswordEmploye(employe.getPasswordEmploye());
		employeACorriger.setPrenomEmploye(employe.getPrenomEmploye());
		return new ResponseEntity<Employe>(employeRepository.save(employeACorriger), HttpStatus.OK);
	}
	
	@PutMapping(value = "/employes/{id}")
	public ResponseEntity<?> supprimerEmploye(@PathVariable Integer idEmploye) {
		Employe employeACorriger = employeRepository.findById(idEmploye).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		employeRepository.deleteById(employeACorriger.getIdEmploye());
		return new ResponseEntity<>("L'employé a bien été supprimé.", HttpStatus.OK);
	}
}
