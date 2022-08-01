package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.models.Client;

public interface IClientService {
	List<Client> findAll();
	Optional<Client> findById(Integer idClient);
	List<Client> findAllBySessionsId(Integer idSession);
	Client add(Client client);
	Client update(Client Client);
	void removeById(Integer id);
}
