package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Domaine;
import com.ittraining.main.services.IDomaineService;

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
public class DomaineRestController {

	@Autowired
	private IDomaineService domaineService;

	@GetMapping(value = "/domaines")
	public ResponseEntity<List<Domaine>> recupererDomaines() {
		return new ResponseEntity<List<Domaine>>(domaineService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/domaines/{id}")
	public ResponseEntity<Optional<Domaine>> recupererDomaineParId(@PathVariable Integer idDomaine) {
		return new ResponseEntity<Optional<Domaine>> (domaineService.findById(idDomaine), HttpStatus.OK);
	}


	@PostMapping(value = "/domaines")
	public ResponseEntity<Domaine> ajouterDomaine(Domaine domaine) {
		return new ResponseEntity<Domaine> (domaineService.add(domaine), HttpStatus.OK);
	}
	
	@PutMapping(value = "/domaines/{id}")
	public ResponseEntity<Domaine> modifierDomaine(@PathVariable Integer idDomaine, Domaine domaine) {
	 Domaine domaineACorriger = domaineService.findById(idDomaine).orElseThrow(
	 			() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	 	domaineACorriger.setNomDomaine(domaine.getNomDomaine());
	 	domaineACorriger.setThemes(domaine.getThemes());
	 	return new ResponseEntity<Domaine> (domaineService.add(domaineACorriger), HttpStatus.OK);
	 }
	
	@DeleteMapping(value = "/domaines/{id}")
	public ResponseEntity<?> supprimerDomaine(@PathVariable Integer idDomaine) {
		 Domaine domaineASupprimer= domaineService.findById(idDomaine).orElseThrow(		
				 () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		domaineService.removeById(domaineASupprimer.getId());
		return new ResponseEntity<> ("Le Prerequis a bien été supprimé.", HttpStatus.OK);
	}
}