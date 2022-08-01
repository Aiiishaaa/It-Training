package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.ThemeRepository;
import com.ittraining.main.models.Formateur;
import com.ittraining.main.models.Formation;
import com.ittraining.main.services.FormateurService;
import com.ittraining.main.services.IFormateurService;
import com.ittraining.main.services.IThemeService;

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
public class FormateurRestController {

	@Autowired
	private IFormateurService formateurService;
	
	
	@GetMapping(value = "/formateurs")
	public ResponseEntity<List<Formateur>> recupererFormateurs() {
		return new ResponseEntity<List<Formateur>>(formateurService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/formateurs/{idFormateur}")
	public ResponseEntity<Optional<Formateur>> recupererFormationParId(@PathVariable Integer idFormateur) {
		return new ResponseEntity<Optional<Formateur>>(formateurService.findById(idFormateur) , HttpStatus.OK);
	}
	
	@PostMapping(value = "/formateurs")
	public ResponseEntity<Formateur> ajouterFormateur(Formateur formateur) {
		return new ResponseEntity<Formateur>(formateurService.add(formateur), HttpStatus.OK);
	}
	
}