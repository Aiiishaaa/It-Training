package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;


import com.ittraining.main.models.Session;
import com.ittraining.main.services.IClientService;
import com.ittraining.main.services.IFormationService;
import com.ittraining.main.services.ISessionService;

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
public class SessionRestController {

	@Autowired
	private IClientService clientService;
	
	@Autowired
	private ISessionService sessionService;
	
	@Autowired
	private IFormationService formationService;
	
	@GetMapping(value = "/sessions")
	public ResponseEntity<List<Session>> recupererSessions() {
		return new ResponseEntity<List<Session>> (sessionService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/session/{id}")
	public ResponseEntity<Optional<Session>> recupererSessionParId(@PathVariable("id") Integer idSession) {
		return new ResponseEntity<Optional<Session>> (sessionService.findById(idSession), HttpStatus.OK);
	}

	@GetMapping(value = "/formations/{id}/sessions")
	public ResponseEntity<List<Session>> recupererSessionsParFormation(@PathVariable("id") Integer idFormation) {
		formationService.findById(idFormation).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Formation non trouvée avec Id " + idFormation));
		List<Session> sessionsParFormation = sessionService.findAllByFormationId(idFormation);
		return new ResponseEntity<>(sessionsParFormation, HttpStatus.OK);
	}
	
	@GetMapping(value = "/clients/{id}/sessions")
	public ResponseEntity<List<Session>> recupererSessionsParClient(@PathVariable("id") Integer idClient) {
		clientService.findById(idClient).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client non trouvé avec Id " + idClient));
		List<Session> sessionsParClient = sessionService.findAllByClientsId(idClient);
		return new ResponseEntity<>(sessionsParClient, HttpStatus.OK);
	}
	
	@PostMapping(value = "/sessions")
	public ResponseEntity<Session> ajouterSession(@RequestBody Session session) {
		return new ResponseEntity<Session> (sessionService.add(session), HttpStatus.OK);
	}
	
	@PutMapping(value = "/session/{id}")
	public ResponseEntity<Session> modifierSession(@PathVariable("id") Integer idSession, @RequestBody Session session) {
		Session sessionACorriger = sessionService.findById(idSession).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		sessionACorriger.setAdresse(session.getAdresse());
		sessionACorriger.setClients(session.getClients());
		sessionACorriger.setDateDebut(session.getDateDebut());
		sessionACorriger.setDateFin(session.getDateFin());
		sessionACorriger.setFormateur(session.getFormateur());
		sessionACorriger.setFormation(session.getFormation());
		return new ResponseEntity<Session> (sessionService.update(sessionACorriger), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/sessions/{id}")
	public ResponseEntity<?> supprimerSession(@PathVariable("id") Integer idSession) {
		Session sessionASupprimer = sessionService.findById(idSession).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session non trouvée avec Id " + idSession));
		sessionService.removeById(sessionASupprimer.getId());
		return new ResponseEntity<> ("La session a bien été supprimée.", HttpStatus.OK);
	}

	
}
