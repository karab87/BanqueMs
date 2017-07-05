package org.sid.metier;

import java.util.List;

import org.sid.dao.ClientRepository;
import org.sid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClientMetierImpl implements ClientMetier {
	@Autowired
	private ClientRepository ClientRepository;
	@Override
	public Client saveClient(Client c) {
		return ClientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		return ClientRepository.findAll();
	}

}
