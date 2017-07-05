package org.sid.dao;

import org.sid.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import ch.qos.logback.core.net.server.Client;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
