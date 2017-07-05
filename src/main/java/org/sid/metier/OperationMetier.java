package org.sid.metier;

import org.sid.entities.PageOperation;



public interface OperationMetier {
	
	public boolean verser(String code,double solde,Long codeEmp);
	public boolean retirer(String code,double solde,Long codeEmp);
	public boolean virement(String cpte1, String code2, double solde, Long codeEmp);
	public PageOperation getOperations(String codeCompte, int page, int size);
	

}
