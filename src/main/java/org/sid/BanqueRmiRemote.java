package org.sid;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.sid.entities.Compte;

public interface BanqueRmiRemote extends Remote {
	
	public boolean verser(String code,double solde,Long codeEmp) throws RemoteException;
	public boolean retirer(String code,double solde,Long codeEmp)throws RemoteException;
	public boolean virement(String cpte1, String code2, double solde, Long codeEmp)throws RemoteException;
	
	public Compte saveCompte(Compte cp) throws RemoteException;
	public Compte getCompte(String code) throws RemoteException;
}
