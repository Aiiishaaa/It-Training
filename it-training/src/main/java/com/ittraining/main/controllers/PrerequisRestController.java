package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Client;
import com.ittraining.main.models.Prerequis;
import com.ittraining.main.services.IClientService;
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
	public ResponseEntity<Optional<Prerequis>> recupererPrerequisParId(@PathVariable Integer idPrerequis) {
		return new ResponseEntity<Optional<Prerequis>> (prerequisService.findById(idPrerequis), HttpStatus.OK);
	}


	@PostMapping(value = "/prerequis")
	public ResponseEntity<Prerequis> ajouterPrerequis(Prerequis prerequis) {
		return new ResponseEntity<Prerequis> (prerequisService.add(prerequis), HttpStatus.OK);
	}
	
	//@PutMapping(value = "/prerequis/{id}")
	//public ResponseEntity<Prerequis> modifierPrerequis(@PathVariable Integer idPrerequis, Prerequis prerequis) {
	//	Prerequis prerequisACorriger = prerequisService.findById(idPrerequis).orElseThrow(
	//			() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	//	prerequisACorriger.setQcm(prerequis.getQcm());
	//	prerequisACorriger.setValidation(prerequis.getValidation());
	//	return new ResponseEntity<Prerequis> (prerequisService.add(prerequisACorriger), HttpStatus.OK);
	//}
	
//	@DeleteMapping(value = "/prerequis/{id}")
//	public ResponseEntity<?> supprimerPrerequis(@PathVariable Integer idPrerequis) {
//		Prerequis prerequisASupprimer = prerequisService.findById(idPrerequis).orElseThrow(
//				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//		prerequisService.removeById(prerequisASupprimer.getIdPrerequis());
//		return new ResponseEntity<> ("Le Prerequis a bien été supprimé.", HttpStatus.OK);
//	}
}