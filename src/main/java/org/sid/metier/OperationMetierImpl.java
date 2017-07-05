package org.sid.metier;

import java.util.Date;

import org.sid.dao.CompteRepository;
import org.sid.dao.EmployeRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Compte;
import org.sid.entities.Employe;
import org.sid.entities.Operation;
import org.sid.entities.PageOperation;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier {
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private EmployeRepository employeRepository;
	
	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.findOne(code);
		Operation o = new Versement();
		Employe e = employeRepository.findOne(codeEmp);
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		return true;
		
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.findOne(code);
		if(cp.getSolde()<montant) throw new RuntimeException("solde insuffisant");
		Operation r = new Retrait();
		Employe e = employeRepository.findOne(codeEmp);
		r.setDateOperation(new Date());
		r.setMontant(montant);
		r.setCompte(cp);
		r.setEmploye(e);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String code2, double montant,
			Long codeEmp) {
		retirer(cpte1,montant,codeEmp);
		verser(code2,montant,codeEmp);
		  return true;
	}

	@Override
	public PageOperation getOperations(String codeCompte, int page, int size) {
		
		Page<Operation> ops = operationRepository.getOperations(codeCompte, new PageRequest(page, size));
		PageOperation pop = new PageOperation();
		pop.setOperations(ops.getContent());
		pop.setNombreOperations(ops.getNumberOfElements());
		pop.setPage(ops.getNumber());
		pop.setTotalPages(ops.getTotalPages());
		pop.setTotalOperations((int)ops.getTotalElements());
		return pop;
	}

}
