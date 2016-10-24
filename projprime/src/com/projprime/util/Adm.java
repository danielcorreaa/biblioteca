package com.projprime.util;

import java.util.Date;
import java.util.List;

import com.projprime.dao.PacienteDAO;
import com.projprime.modelo.Agendar;
import com.projprime.modelo.Paciente;

public class Adm {
	
	public static void main(String[] args) {
		PacienteDAO dao = new PacienteDAO();
		List<Paciente> paci = dao.getLista();
		Agendar agendar = new Agendar();
		
		agendar.setPaciente(paci.get(0));
		agendar.setDataConsulta(new Data(new Date()));
		
		System.out.println(agendar.getPaciente().getNome());
		System.out.println(agendar.getDataConsulta().getData());
	}
	
}
