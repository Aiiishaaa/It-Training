package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.ThemeRepository;
import com.ittraining.main.models.Employe;
import com.ittraining.main.models.Theme;

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
public class ThemeRestController {
	
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@GetMapping(value = "/themes")
	public ResponseEntity<List<Theme>> recupererThemes() {
		return new ResponseEntity<List<Theme>>(themeRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/themes/{id}")
	public ResponseEntity<Optional<Theme>> recupererThemeParId(@PathVariable Integer idTheme) {
		return new ResponseEntity<Optional<Theme>>(themeRepository.findById(idTheme), HttpStatus.OK);
	}
	
	@PostMapping(value = "/themes")
	public ResponseEntity<Theme> ajouterTheme(Theme theme) {
		return new ResponseEntity<Theme>(themeRepository.save(theme), HttpStatus.OK);
	}
	
	@PutMapping(value = "/themes/{id}")
	public ResponseEntity<Theme> modifierTheme(@PathVariable Integer idTheme, Theme theme) {
		Theme themeACorriger = themeRepository.findById(idTheme).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		themeACorriger.setDomaine(theme.getDomaine());
		themeACorriger.setNomTheme(theme.getNomTheme());
		return new ResponseEntity<Theme>(themeRepository.save(themeACorriger), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/themes/{id}")
	public ResponseEntity<?> supprimerTheme(@PathVariable Integer idTheme) {
		Theme themeASupprimer = themeRepository.findById(idTheme).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		themeRepository.deleteById(themeASupprimer.getIdTheme());
		return new ResponseEntity<>("Le thème a bien été supprimé.", HttpStatus.OK);
	}
}