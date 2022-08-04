package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Session;
import com.ittraining.main.models.User;

public interface IUserService {
	List<User> findAll();

	Optional<User> findById(Integer idUser);
	
	User findOneByUsername(String username);

	List<User> findAllBySessionsId(Integer idSession);

	User add(User user);

	User update(User user);

	void removeById(Integer id);
	
	Optional<User> findByFormationsId(Integer idFormation);
	
	//User updateUserSessions(Integer id, Session session);
}
