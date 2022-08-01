package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Session;

public interface ISessionService {
	List<Session> findAll();
	Optional<Session> findById(Integer idSession);
	List<Session> findAllByFormationId(Integer idFormation);
	List<Session> findAllByClientsId(Integer idClient);
	Session add(Session object);
	Session update(Session object);
	void removeById(Integer idSession);
}
