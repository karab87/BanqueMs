package org.sid.metier;

import java.util.List;

import org.sid.entities.Client;
import org.sid.entities.Employe;

public interface EmployeMetier {

	public Employe saveEmploye(Employe e);
	public List<Employe> listEmploye();
}
