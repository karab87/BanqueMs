package org.sid.service;

import java.util.List;

import org.sid.entities.Client;
import org.sid.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestService {
	@Autowired
	private ClientMetier clientMetier;
	@RequestMapping(value="/clients",method=RequestMethod.POST)
	//@ResponseBody --le resultat est recuperer au format JSON.
	//pas besoin de preciser car @RestControllers
	public Client saveClient(@RequestBody Client c) {
		return clientMetier.saveClient(c);
	}
	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	}
	
	
}
