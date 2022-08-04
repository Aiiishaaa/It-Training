package com.ittraining.main.dao;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneByUsername(String username);

	Boolean existsByUsername(String username);

	public List<User> findAllBySessionsId(Integer idSession);

	Optional<User> findByFormationsId(Integer idFormation);
	
//	@Query(value = "UPDATE FROM USERS WHERE ID = ?0", nativeQuery = true)
//	User updateUserSessions(Integer id, Session session);

}