package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.ThemeRepository;
import com.ittraining.main.models.Formation;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
public class FormationRestController {

	@Autowired
	private IFormationService formationService;
	
	@Autowired
	
	
	@GetMapping(value = "/formations")
	public ResponseEntity<List<Formation>> recupererFormations() {
		return new ResponseEntity<List<Formation>>(formationService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/formations/{idFormation}")
	public ResponseEntity<Optional<Formation>> recupererFormationParId(@PathVariable Integer idFormation) {
		return new ResponseEntity<Optional<Formation>>(formationService.findById(idFormation) , HttpStatus.OK);
	}
	
	@PostMapping(value = "/formations")
	public ResponseEntity<Formation> ajouterFormation(Formation formation) {
		return new ResponseEntity<Formation>(formationService.add(formation), HttpStatus.OK);
	}
	
	@PutMapping(value = "/formations/{idFormation}")
	public ResponseEntity<Formation> modifierFormation(@PathVariable Integer idFormation, Formation formation) {
		Formation formationACorriger = formationService.findById(idFormation).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Formation non trouvée avec id : " + idFormation));
		formationACorriger.setDescriptionBreve(formation.getDescriptionBreve());
		formationACorriger.setDescriptionLongue(formation.getDescriptionLongue());
		formationACorriger.setEmploye(formation.getEmploye());
		formationACorriger.setPrerequis(formation.getPrerequis());
		formationACorriger.setTheme(formation.getTheme());
		formationACorriger.setIntitule(formation.getIntitule());
		formationACorriger.setPrix(formation.getPrix());
		formationACorriger.setProgramme(formation.getProgramme());
		formationACorriger.setNbHeures(formation.getNbHeures());
		return new ResponseEntity<Formation>(formationService.update(formationACorriger), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/formations/{idFormation}")
	public ResponseEntity<?> supprimerFormation(@PathVariable Integer idFormation) {
		Formation formationASupprimer = formationService.findById(idFormation).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Formation non trouvée avec id : " + idFormation));
		formationService.removeById(formationASupprimer.getIdFormation());
		return new ResponseEntity<>("La formation a bien été supprimée.", HttpStatus.OK);
	}
	
	@GetMapping(value = "/themes/{idTheme}/formations")
	public ResponseEntity<List<Formation>> recupererFormationsParTheme(@PathVariable Integer idTheme) {
		return themeRepository
		return new ResponseEntity<List<Formation>>(formationService.findAllByTheme(idTheme), HttpStatus.OK);
	}
	
	@GetMapping(value = "/domaines/{idDomaine}/formations")
	public ResponseEntity<List<Formation>> recupererFormationsParDomaine(@PathVariable Integer idDomaine) {
		return new ResponseEntity<List<Formation>>(formationService.findAllByDomaine(idDomaine), HttpStatus.OK);
	}
	
	@GetMapping(value = "/employes/{idEmploye}/formations")
	public ResponseEntity<List<Formation>> recupererFormationsParEmploye(@PathVariable Integer idEmploye) {
		return new ResponseEntity<List<Formation>>(formationService.findAllByEmploye(idEmploye), HttpStatus.OK);
	}
}
