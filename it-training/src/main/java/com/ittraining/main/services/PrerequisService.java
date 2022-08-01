
package com.ittraining.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ittraining.main.dao.PrerequisRepository;
import com.ittraining.main.models.Prerequis;

@Service(value = "prerequisService")
public class PrerequisService implements IPrerequisService {

	@Autowired
	private PrerequisRepository prerequisRepository;

	@Override
	public List<Prerequis> findAll() {
		return prerequisRepository.findAll();
	}

	@Override
	public Optional<Prerequis> findById(Integer id) {
		return prerequisRepository.findById(id);
	}

	@Override
	public Prerequis add(Prerequis prerequis) {
		return prerequisRepository.save(prerequis);
	}

	@Override
	public Prerequis update(Prerequis prerequis) {
		return prerequisRepository.save(prerequis);
	}

	@Override
	public void removeById(Integer id) {
		prerequisRepository.deleteById(id);

	}

}
