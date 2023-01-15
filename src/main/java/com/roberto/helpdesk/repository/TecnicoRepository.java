package com.roberto.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roberto.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
