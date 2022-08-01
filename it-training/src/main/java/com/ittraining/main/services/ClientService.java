package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import com.ittraining.main.dao.ClientRepository;
import com.ittraining.main.models.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "clientService")
public class ClientService implements IClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> findById(Integer id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client add(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client update(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void removeById(Integer id) {
		clientRepository.deleteById(id);

	}

	@Override
	public List<Client> findAllBySessionsId(Integer idSession) {
		return clientRepository.findAllBySessionsId(idSession);
	}

}
