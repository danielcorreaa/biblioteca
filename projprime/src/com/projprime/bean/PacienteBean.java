package com.projprime.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.projprime.dao.PacienteDAO;
import com.projprime.modelo.Paciente;

@ManagedBean
@ViewScoped
public class PacienteBean {

	private List<Paciente> pacientes = new ArrayList<Paciente>();
	private Paciente pacienteSelecionado;
	private Paciente paciente;
	PacienteDAO dao;
	public PacienteBean() {
		super();
		inicializacao();
	}

	public void inicializacao() {
		paciente = new Paciente();
		dao = new PacienteDAO();
		pacientes = dao.getLista();
	}

	public void salvar() {
		//PacienteDAO dao = new PacienteDAO();
		//paciente = new Paciente();
		paciente.setId(new Random().nextInt(50));
		dao.salvar(paciente);
		paciente = new Paciente();
		pacientes = dao.getLista();
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
