package org.sid.dao;

import org.sid.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import ch.qos.logback.core.net.server.Client;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
