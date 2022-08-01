package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Formateur;
import com.ittraining.main.services.IFormateurService;

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
	
	@PutMapping(value = "/formateurs/{id}")
	public ResponseEntity<Formateur> modifierFormateur(@PathVariable Integer idFormateur, Formateur formateur) {
	 Formateur formateurACorriger = formateurService.findById(idFormateur).orElseThrow(
	 			() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	 	formateurACorriger.setNomFormateur(formateur.getNomFormateur());
	 	formateurACorriger.setPrenomFormateur(formateur.getPrenomFormateur());
	 	formateurACorriger.setEmailFormateur(formateur.getEmailFormateur());
	 	formateurACorriger.setPasswordFormateur(formateur.getPasswordFormateur());
	 	formateurACorriger.setSessions(formateur.getSessions());
	 	return new ResponseEntity<Formateur> (formateurService.add(formateurACorriger), HttpStatus.OK);
	 }
	
	@DeleteMapping(value = "/formateurs/{id}")
	public ResponseEntity<?> supprimerFormateur(@PathVariable Integer idFormateur) {
		Formateur formateurASupprimer= formateurService.findById(idFormateur).orElseThrow(		
				 () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		formateurService.removeById(formateurASupprimer.getId());
		return new ResponseEntity<> ("Le formateur a bien été supprimé.", HttpStatus.OK);
	}
}