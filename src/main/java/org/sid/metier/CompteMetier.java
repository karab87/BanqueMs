package org.sid.metier;

import java.util.List;

import org.sid.entities.Client;
import org.sid.entities.Compte;

public interface CompteMetier {

		public Compte saveCompte(Compte cpte);
		public Compte getCompte(String code);
		
}
