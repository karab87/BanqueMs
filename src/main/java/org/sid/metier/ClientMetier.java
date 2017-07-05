package org.sid.metier;

import java.util.List;

import org.sid.entities.Client;

public interface ClientMetier {

		public Client saveClient(Client c);
		public List<Client> listClient();
		
}
