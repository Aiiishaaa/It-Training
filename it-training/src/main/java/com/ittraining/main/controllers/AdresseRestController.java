package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.AdresseRepository;
import com.ittraining.main.models.Adresse;

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
public class AdresseRestController {

	@Autowired
	private AdresseRepository adresseRepository;
	
	@GetMapping(value = "/adresses")
	public ResponseEntity<List<Adresse>> findAll() {
		return new ResponseEntity<List<Adresse>>(adresseRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/adresses/{id}")
	public ResponseEntity<Optional<Adresse>> findById(@PathVariable Integer idAdresse) {
		return new ResponseEntity<Optional<Adresse>>(adresseRepository.findById(idAdresse), HttpStatus.OK);
	}
	
	@PostMapping(value = "/adresses")
	public ResponseEntity<Adresse> ajouterTheme(Adresse adresse) {
		return new ResponseEntity<Adresse>(adresseRepository.save(adresse), HttpStatus.OK);
	}
	
	@PutMapping(value = "/adresses/{id}")
	public ResponseEntity<Adresse> update(@PathVariable Integer idAdresse, Adresse adresse) {
		Adresse adresseToUpdate = adresseRepository.findById(idAdresse).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		adresseToUpdate.setNoAdresse(adresse.getNoAdresse());
		adresseToUpdate.setRue(adresse.getRue());
		adresseToUpdate.setCodePostal(adresse.getCodePostal());
		adresseToUpdate.setVille(adresse.getVille());
		return new ResponseEntity<Adresse>(adresseRepository.save(adresseToUpdate), HttpStatus.OK);
	}
	
//	@DeleteMapping(value = "/adresses/{id}")
//	public ResponseEntity<?> removeById(@PathVariable Integer idAdresse) {
////		Adresse adresseToRemove = adresseRepository.findById(idAdresse).orElseThrow(
////				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
////		adresseRepository.deleteById(adresseToRemove.getIdAdresse());
//		return new ResponseEntity<>("L'adresse a bien été supprimé.", HttpStatus.OK);
//	}
}
