package com.projprime.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.projprime.modelo.Agendar;
import com.projprime.modelo.Paciente;
import com.projprime.util.Data;

public class AgendaDAO {
	
	private List<Agendar> lista = new ArrayList<Agendar>();

	public AgendaDAO() {
		super();
		getBanco();
	}

	private void getBanco() {
		
	}
	
	public Agendar getId(Integer id){
		for(Agendar agendar:lista){
			if(agendar.getId() == id){
				return agendar;
			}
		}
		return null;
	}
	
	public void salvar(Agendar agendar){
		getLista().add(agendar);
	}

	public List<Agendar> getLista() {
		return lista;
	}

	public void setLista(List<Agendar> lista) {
		this.lista = lista;
	}

	
	
	

}
