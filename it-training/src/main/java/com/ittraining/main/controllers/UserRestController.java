package com.ittraining.main.controllers;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.User;
import com.ittraining.main.services.IUserService;
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
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISessionService sessionService;
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> recupererUsers() {
		return new ResponseEntity<List<User>> (userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<Optional<User>> recupererUserParId(@PathVariable("id") Integer idUser) {
		return new ResponseEntity<Optional<User>> (userService.findById(idUser), HttpStatus.OK);
	}

	@GetMapping(value = "/sessions/{id}/users")
	public ResponseEntity<List<User>> recupererUserParSession(@PathVariable("id") Integer idSession) {
		sessionService.findById(idSession).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session non trouvée avec Id " + idSession));
		List<User> usersParSession = userService.findAllBySessionsId(idSession);
		return new ResponseEntity<>(usersParSession, HttpStatus.OK);
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<User> ajouterUser(@RequestBody User user) {
		return new ResponseEntity<User> (userService.add(user), HttpStatus.OK);
	}
	
	@PutMapping(value = "/users/{id}")
	public ResponseEntity<User> modifierUser(@PathVariable("id") Integer idUser, @RequestBody User user) {
		User userACorriger = userService.findById(idUser).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		userACorriger.setEmail(user.getEmail());
		userACorriger.setName(user.getName());
		userACorriger.setPassword(user.getPassword());
		userACorriger.setUsername(user.getUsername());
		return new ResponseEntity<User> (userService.add(userACorriger), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<?> supprimerUser(@PathVariable("id") Integer idClient) {
		User userASupprimer = userService.findById(idClient).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		userService.removeById(userASupprimer.getId());
		return new ResponseEntity<> ("Le client a bien été supprimé.", HttpStatus.OK);
	}
}
