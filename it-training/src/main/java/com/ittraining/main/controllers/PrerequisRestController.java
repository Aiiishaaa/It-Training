package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Prerequis;
import com.ittraining.main.services.IPrerequisService;

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
public class PrerequisRestController {
	
	@Autowired
	private IPrerequisService prerequisService;
	
	@GetMapping(value = "/prerequis")
	public ResponseEntity<List<Prerequis>> recupererPrerequis() {
		return new ResponseEntity<List<Prerequis>> (prerequisService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/prerequis/{id}")
	public ResponseEntity<Optional<Prerequis>> recupererPrerequisParId(@PathVariable("id") Integer idPrerequis) {
		return new ResponseEntity<Optional<Prerequis>> (prerequisService.findById(idPrerequis), HttpStatus.OK);
	}


	@PostMapping(value = "/prerequis")
	public ResponseEntity<Prerequis> ajouterPrerequis(@RequestBody Prerequis prerequis) {
		return new ResponseEntity<Prerequis> (prerequisService.add(prerequis), HttpStatus.OK);
	}
	
	@PutMapping(value = "/prerequis/{id}")
	public ResponseEntity<Prerequis> modifierPrerequis(@PathVariable("id") Integer idPrerequis, @RequestBody Prerequis prerequis) {
	 Prerequis prerequisACorriger = prerequisService.findById(idPrerequis).orElseThrow(
	 			() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prerequis non trouvé avec l'id " + idPrerequis));
	 	prerequisACorriger.setQcmPrerequis(prerequis.getQcmPrerequis());
	 	prerequisACorriger.setValidationPrerequis(prerequis.isValidationPrerequis());
	 	prerequisACorriger.setFormation(prerequis.getFormation());
	 	return new ResponseEntity<Prerequis> (prerequisService.add(prerequisACorriger), HttpStatus.OK);
	 }
	
	@DeleteMapping(value = "/prerequis/{id}")
	public ResponseEntity<?> supprimerPrerequis(@PathVariable("id") Integer idPrerequis) {
		Prerequis prerequisASupprimer = prerequisService.findById(idPrerequis).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND,  "Prerequis non trouvé avec l'id " + idPrerequis));
		prerequisService.removeById(prerequisASupprimer.getId());
		return new ResponseEntity<> ("Le Prerequis a bien été supprimé.", HttpStatus.OK);
	}
}