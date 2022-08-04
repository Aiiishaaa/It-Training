package com.ittraining.main.dao;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneByUsername(String username);

	Boolean existsByUsername(String username);

	public List<User> findAllBySessionsId(Integer idSession);

	Optional<User> findByFormationsId(Integer idFormation);

}