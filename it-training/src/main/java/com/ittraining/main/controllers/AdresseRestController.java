package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Adresse;
import com.ittraining.main.services.IAdresseService;

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
public class AdresseRestController {

	@Autowired
	private IAdresseService adresseService;

	@GetMapping(value = "/adresses")
	public ResponseEntity<List<Adresse>> recupererAdresses() {
		return new ResponseEntity<List<Adresse>>(adresseService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/adresses/{id}")
	public ResponseEntity<Optional<Adresse>> recupererAdresseParId(@PathVariable("id") Integer idAdresse) {
		return new ResponseEntity<Optional<Adresse>>(adresseService.findById(idAdresse), HttpStatus.OK);
	}

	@PostMapping(value = "/adresses")
	public ResponseEntity<Adresse> ajouterAdresse(@RequestBody Adresse adresse) {
		return new ResponseEntity<Adresse>(adresseService.add(adresse), HttpStatus.OK);
	}

	@PutMapping(value = "/adresses/{id}")
	public ResponseEntity<Adresse> modifierAdresse(@PathVariable("id") Integer idAdresse, @RequestBody Adresse adresse) {
		Adresse adresseToUpdate = adresseService.findById(idAdresse).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Adresse non trouvée avec id" + idAdresse));
		adresseToUpdate.setNoAdresse(adresse.getNoAdresse());
		adresseToUpdate.setRue(adresse.getRue());
		adresseToUpdate.setCodePostal(adresse.getCodePostal());
		adresseToUpdate.setVille(adresse.getVille());
		adresseToUpdate.setSessions(adresse.getSessions());
		return new ResponseEntity<Adresse>(adresseService.update(adresseToUpdate), HttpStatus.OK);
	}

	@DeleteMapping(value = "/adresses/{id}")
	public ResponseEntity<?> supprimerAdresseParId(@PathVariable("id") Integer id) {
		Adresse adresseToRemove = adresseService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Adresse non trouvée avec id" + id));
		adresseService.removeById(adresseToRemove.getId());
		return new ResponseEntity<>("L'adresse a bien été supprimé.", HttpStatus.OK);
	}

	@GetMapping(value = "/sessions/{id}/adresse")
	public ResponseEntity<Adresse> findOneBySessionsId(@PathVariable("id") Integer id) {
		adresseService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + id));
		Adresse adresse = adresseService.findOneBySessionsId(id);
		return new ResponseEntity<Adresse>(adresse, HttpStatus.OK);
	}
}
