package org.sid.metier;

import java.util.Date;

import org.sid.dao.CompteRepository;
import org.sid.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompteMetierImpl implements CompteMetier {
	@Autowired
	private CompteRepository compteRepository;
	@Override
	public Compte saveCompte(Compte cpte) {
		cpte.setDateCreation(new Date());
		return compteRepository.save(cpte);
	}

	@Override
	public Compte getCompte(String code) {
		
		return compteRepository.findOne(code);
	}

}
