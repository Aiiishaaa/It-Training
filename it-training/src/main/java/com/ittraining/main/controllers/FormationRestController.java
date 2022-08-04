package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Formation;
import com.ittraining.main.services.IDomaineService;
import com.ittraining.main.services.IEmployeService;
import com.ittraining.main.services.IFormationService;
import com.ittraining.main.services.IThemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
public class FormationRestController {

	@Autowired
	private IFormationService formationService;

	@Autowired
	private IThemeService themeService;

	@Autowired
	private IDomaineService domaineService;

	@Autowired
	private IEmployeService employeService;

	// http://localhost:8080/formations
	@GetMapping(value = "/formations")
	public ResponseEntity<List<Formation>> recupererFormations() {
		return new ResponseEntity<>(formationService.findAll(), HttpStatus.OK);
	}

	// http://localhost:8080/forms/informatique
	@GetMapping(value = "/forms/{nomDomaine}")
	public ResponseEntity<List<Formation>> recupererFormationsByDomaine(@PathVariable String nomDomaine) {
		return new ResponseEntity<>(formationService.findAllByDomaine(nomDomaine), HttpStatus.OK);
	}
	
	// http://localhost:8080/forma/communication
	@GetMapping(value = "/forma/{nomTheme}")
	public ResponseEntity<List<Formation>> recupererFormationsByTheme(@PathVariable String nomTheme) {
		return new ResponseEntity<>(formationService.findAllByTheme(nomTheme), HttpStatus.OK);
	}

	// http://localhost:8080/formations
	// http://localhost:8080/formations?page=0&size=6
	// http://localhost:8080/formations?size=6
	// http://localhost:8080/formations?domaine=informatique&page=0&size=6
	@GetMapping(value = "/formationsFilter")
	public ResponseEntity<Page<Formation>> recupererFormations(@RequestParam(required = false) String domaine,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {

		Pageable paging = PageRequest.of(page, size);
		Page<Formation> pageForms;

		pageForms = formationService.findByDomaineContaining(domaine, paging);
		return new ResponseEntity<>(pageForms, HttpStatus.OK);
	}

	@GetMapping(value = "/formations/{id}")
	public ResponseEntity<Optional<Formation>> recupererFormationParId(@PathVariable("id") Integer idFormation) {
		return new ResponseEntity<Optional<Formation>>(formationService.findById(idFormation), HttpStatus.OK);
	}

	@PostMapping(value = "/formations")
	public ResponseEntity<Formation> ajouterFormation(@RequestBody Formation formation) {
		return new ResponseEntity<Formation>(formationService.add(formation), HttpStatus.OK);
	}

	@PutMapping(value = "/formations/{id}")
	public ResponseEntity<Formation> modifierFormation(@PathVariable("id") Integer idFormation,
			@RequestBody Formation formation) {
		Formation formationACorriger = formationService.findById(idFormation)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Formation non trouvée avec id : " + idFormation));
		formationACorriger.setDescriptionBreve(formation.getDescriptionBreve());
		formationACorriger.setDescriptionLongue(formation.getDescriptionLongue());
		formationACorriger.setEmploye(formation.getEmploye());
		formationACorriger.setPrerequis(formation.getPrerequis());
		formationACorriger.setTheme(formation.getTheme());
		formationACorriger.setIntitule(formation.getIntitule());
		formationACorriger.setPrix(formation.getPrix());
		formationACorriger.setProgramme(formation.getProgramme());
		formationACorriger.setNbHeures(formation.getNbHeures());
		formationACorriger.setUrlImage(formation.getUrlImage());
		return new ResponseEntity<Formation>(formationService.update(formationACorriger), HttpStatus.OK);
	}

	@DeleteMapping(value = "/formations/{id}")
	public ResponseEntity<?> supprimerFormation(@PathVariable("id") Integer idFormation) {
		Formation formationASupprimer = formationService.findById(idFormation)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Formation non trouvée avec id : " + idFormation));
		formationService.removeById(formationASupprimer.getId());
		return new ResponseEntity<>("La formation a bien été supprimée.", HttpStatus.OK);
	}

	@GetMapping(value = "/themes/{id}/formations")
	public ResponseEntity<List<Formation>> recupererFormationsParTheme(@PathVariable("id") Integer idTheme) {
		themeService.findById(idTheme).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Thème non trouvé avec id : " + idTheme));
		return new ResponseEntity<List<Formation>>(formationService.findAllByThemeId(idTheme), HttpStatus.OK);
	}

	@GetMapping(value = "/domaines/{id}/formations")
	public ResponseEntity<List<Formation>> recupererFormationsParDomaine(@PathVariable("id") Integer idDomaine) {
		domaineService.findById(idDomaine).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Domaine non trouvé avec id : " + idDomaine));
		return new ResponseEntity<List<Formation>>(formationService.findAllByDomaineId(idDomaine), HttpStatus.OK);
	}

	@GetMapping(value = "/employes/{id}/formations")
	public ResponseEntity<List<Formation>> recupererFormationsParEmploye(@PathVariable("id") Integer idEmploye) {
		employeService.findById(idEmploye).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employé non trouvé avec id : " + idEmploye));
		return new ResponseEntity<List<Formation>>(formationService.findAllByEmployeId(idEmploye), HttpStatus.OK);
	}
}
