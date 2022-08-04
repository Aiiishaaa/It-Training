package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.UserRepository;
import com.ittraining.main.models.Session;
import com.ittraining.main.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "clientService")
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public User add(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void removeById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findAllBySessionsId(Integer idSession) {
		return userRepository.findAllBySessionsId(idSession);
	}

	@Override
	public User findOneByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}

	@Override
	public Optional<User> findByFormationsId(Integer idFormation) {
		return userRepository.findByFormationsId(idFormation);
	}

//	@Override
//	public User updateUserSessions(Integer id, Session session) {
//		return userRepository.updateUserSessions(id, session);
//	}

}
