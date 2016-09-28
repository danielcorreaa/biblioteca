package com.projprime.dao;

import java.util.ArrayList;
import java.util.List;

import com.projprime.modelo.Paciente;
import com.projprime.util.Data;

public class PacienteDAO {
	
	private List<Paciente> lista = new ArrayList<Paciente>();

	public PacienteDAO() {
		super();
		getBanco();
	}

	private void getBanco() {
		Paciente paci1 = new Paciente();
		paci1.setId(3443);
		paci1.setNome("Daniel Correa");
		paci1.setData(new Data(paci1.getData().stringforDate("17/11/1983")));
		lista.add(paci1);
		
	}
	
	public void salvar(Paciente paciente){
		getLista().add(paciente);
	}

	public List<Paciente> getLista() {
		return lista;
	}

	public void setLista(List<Paciente> lista) {
		this.lista = lista;
	}
	
	

}
