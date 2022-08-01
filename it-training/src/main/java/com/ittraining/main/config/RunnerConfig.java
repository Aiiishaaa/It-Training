package com.ittraining.main.config;

import com.ittraining.main.dao.AdresseRepository;
import com.ittraining.main.dao.ClientRepository;
import com.ittraining.main.dao.DomaineRepository;
import com.ittraining.main.dao.EmployeRepository;
import com.ittraining.main.dao.FormateurRepository;
import com.ittraining.main.dao.FormationRepository;
import com.ittraining.main.dao.PrerequisRepository;
import com.ittraining.main.dao.RoleRepository;
import com.ittraining.main.dao.SessionRepository;
import com.ittraining.main.dao.ThemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RunnerConfig implements CommandLineRunner {

	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private AdresseRepository adresseRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private DomaineRepository domaineRepository;
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@Autowired
	private EmployeRepository employeRepository;
	
	@Autowired
	private FormateurRepository formateurRepository;
	
	@Autowired
	private PrerequisRepository prerequisRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
