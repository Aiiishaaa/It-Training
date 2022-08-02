package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Domaine;
import com.ittraining.main.models.Theme;
import com.ittraining.main.services.IDomaineService;
import com.ittraining.main.services.IFormationService;

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
public class DomaineRestController {

	@Autowired
	private IDomaineService domaineService;
	
	@Autowired
	private IFormationService formationService;

	@GetMapping(value = "/domaines")
	public ResponseEntity<List<Domaine>> recupererDomaines() {
		return new ResponseEntity<List<Domaine>>(domaineService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/domaines/{id}")
	public ResponseEntity<Optional<Domaine>> recupererDomaineParId(@PathVariable("id") Integer idDomaine) {
		return new ResponseEntity<Optional<Domaine>>(domaineService.findById(idDomaine), HttpStatus.OK);
	}

	@GetMapping(value = "/formations/{id}/domaines")
	public ResponseEntity<Domaine> recupererThemeParFormation(@PathVariable("id") Integer idFormation) {
		formationService.findById(idFormation).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Formation non trouvée avec Id " + idFormation));
		Domaine domaine = domaineService.findByFormationsId(idFormation);
		return new ResponseEntity<Domaine>(domaine, HttpStatus.OK);
	}
	
	@PostMapping(value = "/domaines")
	public ResponseEntity<Domaine> ajouterDomaine(@RequestBody Domaine domaine) {
		return new ResponseEntity<Domaine>(domaineService.add(domaine), HttpStatus.OK);
	}

	@PutMapping(value = "/domaines/{id}")
	public ResponseEntity<Domaine> modifierDomaine(@PathVariable("id") Integer idDomaine,
			@RequestBody Domaine domaine) {
		Domaine domaineACorriger = domaineService.findById(idDomaine)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Domaine non trouvé avec Id " + idDomaine));
		domaineACorriger.setNomDomaine(domaine.getNomDomaine());
		domaineACorriger.setThemes(domaine.getThemes());
		return new ResponseEntity<Domaine>(domaineService.add(domaineACorriger), HttpStatus.OK);
	}

	@DeleteMapping(value = "/domaines/{id}")
	public ResponseEntity<?> supprimerDomaine(@PathVariable("id") Integer idDomaine) {
		Domaine domaineASupprimer = domaineService.findById(idDomaine)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,  "Domaine non trouvé avec Id " + idDomaine));
		domaineService.removeById(domaineASupprimer.getId());
		return new ResponseEntity<>("Le Prerequis a bien été supprimé.", HttpStatus.OK);
	}
}