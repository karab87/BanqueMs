package org.sid;

import java.rmi.RemoteException;

import org.sid.entities.Compte;
import org.sid.metier.CompteMetier;
import org.sid.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("myRmiService")
public class BanqueRmiImpl implements BanqueRmiRemote {
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;
	
	@Override
	public boolean verser(String code, double montant, Long codeEmp)
			throws RemoteException {
		return operationMetier.verser(code, montant, codeEmp);
	}

	@Override
	public boolean retirer(String code, double montant, Long codeEmp)
			throws RemoteException {
		return operationMetier.retirer(code, montant, codeEmp);
	}

	@Override
	public boolean virement(String cpte1, String code2, double montant,
			Long codeEmp) throws RemoteException {
		return operationMetier.virement(cpte1, code2, montant, codeEmp);
	}

	@Override
	public Compte saveCompte(Compte cp) throws RemoteException {
		return compteMetier.saveCompte(cp);
	}

	@Override
	public Compte getCompte(String code) throws RemoteException {
		return compteMetier.getCompte(code);
	}

}
