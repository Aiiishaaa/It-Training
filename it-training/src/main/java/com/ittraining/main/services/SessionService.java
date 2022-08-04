package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.SessionRepository;
import com.ittraining.main.models.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "sessionService")
public class SessionService implements ISessionService {

	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public List<Session> findAll() {
		return sessionRepository.findAll();
	}

	@Override
	public Optional<Session> findById(Integer idSession) {
		return sessionRepository.findById(idSession);
	}

	@Override
	public List<Session> findAllByFormationId(Integer idFormation) {
		return sessionRepository.findAllByFormationId(idFormation);
	}

	@Override
	public List<Session> findAllSessionsByUsersId(Integer idUser) {
		return sessionRepository.findAllSessionsByUsersId(idUser);
	}

	@Override
	public Session add(Session session) {
		return sessionRepository.save(session);
	}

	@Override
	public Session update(Session session) {
		return sessionRepository.save(session);
	}

	@Override
	public void removeById(Integer idSession) {
		sessionRepository.deleteById(idSession);

	}

//	@Override
//	public Session updateOneSessionsByUsers(Session session) {
//		return sessionRepository.updateOneSessionsByUsers(session);
//	}



}
