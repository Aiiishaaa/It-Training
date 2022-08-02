
package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Theme;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
public class ThemeRestController {

	@Autowired
	private IThemeService themeService;

	@GetMapping(value = "/themes")
	public ResponseEntity<List<Theme>> recupererThemes() {
		return new ResponseEntity<List<Theme>>(themeService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/themes/{id}")
	public ResponseEntity<Optional<Theme>> recupererThemeParId(@PathVariable("id") Integer idTheme) {
		return new ResponseEntity<Optional<Theme>>(themeService.findById(idTheme), HttpStatus.OK);
	}

	@PostMapping(value = "/themes")
	public ResponseEntity<Theme> ajouterTheme(@RequestBody Theme theme) {
		return new ResponseEntity<Theme>(themeService.add(theme), HttpStatus.OK);
	}

	@PutMapping(value = "/themes/{id}")
	public ResponseEntity<Theme> modifierTheme(@PathVariable("id") Integer idTheme, @RequestBody Theme theme) {
		Theme themeACorriger = themeService.findById(idTheme)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Thème non trouvé avec l'id " + idTheme));
		themeACorriger.setDomaine(theme.getDomaine());
		themeACorriger.setNomTheme(theme.getNomTheme());
		return new ResponseEntity<Theme>(themeService.update(themeACorriger), HttpStatus.OK);
	}

	@DeleteMapping(value = "/themes/{id}")
	public ResponseEntity<?> supprimerTheme(@PathVariable("id") Integer idTheme) {
		Theme themeASupprimer = themeService.findById(idTheme)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Thème non trouvé avec l'id " + idTheme));
		themeService.removeById(themeASupprimer.getId());
		return new ResponseEntity<>("Le thème a bien été supprimé.", HttpStatus.OK);
	}
}
