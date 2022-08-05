package com.ittraining.main.dao;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Session;
import com.ittraining.main.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneByUsername(String username);

	Boolean existsByUsername(String username);

	public List<User> findAllBySessionsId(Integer idSession);

	Optional<User> findByFormationsId(Integer idFormation);
	
	@Query("UPDATE User SET sessions = :session where id = :id")
	User updateUserSessions(Integer id, Session session);

}