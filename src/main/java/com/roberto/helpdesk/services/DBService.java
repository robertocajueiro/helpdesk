package com.roberto.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Roberto Dantas", "09145050090", "roberto@mail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Lucas Cajueiro", "19348188011", "lucas@mail.com", encoder.encode("123"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 012", "Primeiro Chamado", tec1, cli1);
		Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 02", "Segundo Chamado", tec1, cli1);
		Chamado c4 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 03", "Terceiro Chamado", tec1, cli1);
		Chamado c5 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 04", "Quarto Chamado", tec1, cli1);
		Chamado c6 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 05", "Quinto Chamado", tec1, cli1);
		Chamado c7 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 06", "sexto Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		chamadoRepository.saveAll(Arrays.asList(c1));
		chamadoRepository.saveAll(Arrays.asList(c2));
		chamadoRepository.saveAll(Arrays.asList(c3));
		chamadoRepository.saveAll(Arrays.asList(c4));
		chamadoRepository.saveAll(Arrays.asList(c5));
		chamadoRepository.saveAll(Arrays.asList(c6));
		chamadoRepository.saveAll(Arrays.asList(c7));
	}

}
