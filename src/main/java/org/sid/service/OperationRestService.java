package org.sid.service;

import org.sid.entities.PageOperation;
import org.sid.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {
	@Autowired
	private OperationMetier operationMetier;

	@RequestMapping(value = "/versement", method = RequestMethod.PUT)
	public boolean verser(@RequestParam String code,
			@RequestParam double montant, @RequestParam Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}

	@RequestMapping(value = "/retrait", method = RequestMethod.PUT)
	public boolean retirer(@RequestParam String code,
			@RequestParam double montant, @RequestParam Long codeEmp) {
		return operationMetier.retirer(code, montant, codeEmp);
	}

	@RequestMapping(value = "/virement", method = RequestMethod.PUT)
	public boolean virement(@RequestParam String cpte1,
			@RequestParam String cpte2, @RequestParam double montant,
			@RequestParam Long codeEmp) {

		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	}

	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public PageOperation getOperations(@RequestParam String codeCompte,
			@RequestParam int page, @RequestParam int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}

}
