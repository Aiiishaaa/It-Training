package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Client;
import com.ittraining.main.services.IClientService;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private ISessionService sessionService;
	
	@GetMapping(value = "/clients")
	public ResponseEntity<List<Client>> recupererClients() {
		return new ResponseEntity<List<Client>> (clientService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/clients/{id}")
	public ResponseEntity<Optional<Client>> recupererClientParId(@PathVariable Integer idClient) {
		return new ResponseEntity<Optional<Client>> (clientService.findById(idClient), HttpStatus.OK);
	}

	@GetMapping(value = "/sessions/{id}/clients")
	public ResponseEntity<List<Client>> recupererClientParSession(@PathVariable Integer idSession) {
		sessionService.findById(idSession).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session non trouvée avec Id " + idSession));
		List<Client> clientsParSession = clientService.findAllBySessionId(idSession);
		return new ResponseEntity<> (clientsParSession, HttpStatus.OK);
	}
	
	@PostMapping(value = "/clients")
	public ResponseEntity<Client> ajouterClient(Client client) {
		return new ResponseEntity<Client> (clientService.add(client), HttpStatus.OK);
	}
	
	@PutMapping(value = "/clients/{id}")
	public ResponseEntity<Client> modifierClient(@PathVariable Integer idClient, Client client) {
		Client clientACorriger = clientService.findById(idClient).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		clientACorriger.setEmailClient(client.getEmailClient());
		clientACorriger.setNomClient(client.getNomClient());
		clientACorriger.setPasswordClient(client.getPasswordClient());
		clientACorriger.setPrenomClient(client.getPrenomClient());
		return new ResponseEntity<Client> (clientService.add(clientACorriger), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/clients/{id}")
	public ResponseEntity<?> supprimerClient(@PathVariable Integer idClient) {
		Client clientASupprimer = clientService.findById(idClient).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		clientService.removeById(clientASupprimer.getIdClient());
		return new ResponseEntity<> ("Le client a bien été supprimé.", HttpStatus.OK);
	}
}
