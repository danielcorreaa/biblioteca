package com.projprime.modelo;

import com.projprime.util.Data;

public class Agendar {

	private Integer id;
	private Paciente paciente;
	private Data dataConsulta;

	public Agendar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Data getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Data dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

}
