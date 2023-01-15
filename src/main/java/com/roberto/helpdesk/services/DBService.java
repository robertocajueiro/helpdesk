package com.roberto.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.helpdesk.domain.Chamado;
import com.roberto.helpdesk.domain.Cliente;
import com.roberto.helpdesk.domain.Tecnico;
import com.roberto.helpdesk.domain.enums.Perfil;
import com.roberto.helpdesk.domain.enums.Prioridade;
import com.roberto.helpdesk.domain.enums.Status;
import com.roberto.helpdesk.repository.ChamadoRepository;
import com.roberto.helpdesk.repository.ClienteRepository;
import com.roberto.helpdesk.repository.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Roberto Dantas", "09145050090", "roberto@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Lucas Cajueiro", "19348188011", "lucas@mail.com", "123" );
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
