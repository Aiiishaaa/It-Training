
package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ittraining.main.models.Prerequis;

@Service(value = "prerequisService")
public class PrerequisService implements IPrerequisService {

	@Override
	public List<Prerequis> findAll() {
		return null;
	}

	@Override
	public Optional<Prerequis> findById(Integer id) {
		return Optional.empty();
	}

	@Override
	public Prerequis add(Prerequis object) {
		return null;
	}

	@Override
	public Prerequis update(Prerequis object) {
		return null;
	}

	@Override
	public void removeById(Integer id) {

	}

}
