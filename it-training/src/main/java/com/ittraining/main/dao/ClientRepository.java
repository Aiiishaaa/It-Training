package com.ittraining.main.dao;

import java.util.List;

import com.ittraining.main.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	public List<Client> findAllBySessionsId(Integer idSession);
}
