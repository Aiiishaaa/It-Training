package com.ittraining.main.dao;

import java.util.List;

import com.ittraining.main.models.Session;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
	List<Session> findAllByFormationId(Integer idFormation);
	List<Session> findAllSessionsByUsersId(Integer idUser);
	//Session updateOneSessionsByUsers(Session session);
	
}
