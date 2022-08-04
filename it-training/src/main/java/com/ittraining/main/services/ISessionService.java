package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Session;

public interface ISessionService {
	List<Session> findAll();
	Optional<Session> findById(Integer idSession);
	List<Session> findAllByFormationId(Integer idFormation);
	Session add(Session object);
//	Session saveOneSessionsByUsers(Integer idUser, Session session);
	Session update(Session object);
	void removeById(Integer idSession);
	List<Session> findAllSessionsByUsersId(Integer idUser);
	

}
