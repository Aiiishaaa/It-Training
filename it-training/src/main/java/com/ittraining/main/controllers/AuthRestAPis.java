package com.ittraining.main.controllers;


import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import com.ittraining.main.messages.request.LoginForm;
import com.ittraining.main.messages.request.SignUpForm;
import com.ittraining.main.messages.response.JwtResponse;
import com.ittraining.main.messages.response.ResponseMessage;
import com.ittraining.main.models.Role;
import com.ittraining.main.models.RoleName;
import com.ittraining.main.dao.RoleRepository;
import com.ittraining.main.dao.UserRepository;
import com.ittraining.main.security.jtw.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ittraining.main.models.User;

// Ce contrôleur fournit des API pour les actions d'enregistrement et de connexion.

//– /api/auth/signin
//
//    authentifier { nom d'utilisateur, mot de passe }
//    mettre à jour SecurityContext à l'aide de l'objet Authentication
//    générer JWT
//    obtenir les détails de l'utilisateur à partir de l'objet d'authentification
//    la réponse contient des données JWT et UserDetails

//– /api/auth/signup
//
//    vérifier le nom d'utilisateur / e-mail existant A faire
//    créer un nouvel utilisateur (avec ROLE_USER si le rôle n'est pas spécifié)
//    enregistrer l'utilisateur dans la base de données à l'aide de UserRepository

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPis {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);

		UserDetails user = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, user.getUsername(), user.getAuthorities()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {

		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByDesignation(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause : User role not find"));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "client":
						Role clientRole = roleRepository.findByDesignation(RoleName.ROLE_CLIENT)
								.orElseThrow(() -> new RuntimeException("Fail! -> Cause : User  role not find"));
						roles.add(clientRole);
				case "employe":
					Role employeRole = roleRepository.findByDesignation(RoleName.ROLE_EMPLOYE)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause : User role not find"));
					roles.add(employeRole);
				case "admin":
					Role adminRole = roleRepository.findByDesignation(RoleName.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause : User role not find"));
					roles.add(adminRole);
				default:
					Role userRole = roleRepository.findByDesignation(RoleName.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause : User role not find"));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User Registered successfully"), HttpStatus.OK);

	}
}