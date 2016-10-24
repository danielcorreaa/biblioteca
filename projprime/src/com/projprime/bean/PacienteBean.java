package com.projprime.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.projprime.dao.PacienteDAO;
import com.projprime.modelo.Paciente;

@Model
public class PacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Paciente> pacientes;
	private Paciente pacienteSelecionado;
	private Paciente paciente;
	
	@Inject
	private PacienteDAO dao;
	
	public PacienteBean() {
		super();
		inicializacao();
	}

	public void inicializacao() {
		paciente = new Paciente();		
		pacientes = dao.getLista();
	}

	public void salvar() {		
		dao.salvar(paciente);
		paciente = new Paciente();		
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
