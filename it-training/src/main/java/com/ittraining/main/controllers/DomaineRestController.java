package com.ittraining.main.controllers;

import java.util.List;

import com.ittraining.main.models.Domaine;
import com.ittraining.main.services.IDomaineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class DomaineRestController {

	@Autowired
	private IDomaineService domaineService;

	@GetMapping(value = "/domaines")
	public ResponseEntity<List<Domaine>> recupererFormateurs() {
		return new ResponseEntity<List<Domaine>>(domaineService.findAll(), HttpStatus.OK);
	}

}