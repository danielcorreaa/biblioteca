package com.projprime.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.projprime.dao.PacienteDAO;
import com.projprime.modelo.Agendar;
import com.projprime.modelo.Paciente;
import com.projprime.util.Data;

@ManagedBean
@ViewScoped
public class AgendarBean implements Serializable {

	private static final long serialVersionUID = -2572141871554221745L;
	private ScheduleModel eventModel;
	private Agendar agendar;
	private ScheduleEvent event = new DefaultScheduleEvent();
	private List<Paciente> pacientes;

	public AgendarBean() {
		super();
		agendar = new Agendar();
		PacienteDAO dao = new PacienteDAO();
		pacientes = dao.getLista();
	}

	@PostConstruct
	public void init() {
		eventModel = new DefaultScheduleModel();		
		
	}

	// corrige bug primefaces
	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject(), true);
		Calendar c = Calendar.getInstance();
		c.setTime(event.getStartDate());
		c.add(Calendar.HOUR_OF_DAY, 1);
		agendar.setDataConsulta(new Data(c.getTime()));

	}
	public List<Paciente> buscarPacientes(String qry){
		List<Paciente> sugestoes = new ArrayList<Paciente>();
		for (Paciente paciente: pacientes) {
			if(paciente.getNome().toUpperCase().startsWith(qry.toUpperCase())){
				sugestoes.add(paciente);
			}
		}
		return sugestoes;
	}
	
	public void salvar(ActionEvent Actionevent){
		
		if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);
         
        event = new DefaultScheduleEvent();
		
	   //eventModel.addEvent(new DefaultScheduleEvent(agendar.getPaciente().getNome(), agendar.getDataConsulta().getData(), agendar.getDataConsulta().getData()));
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public Agendar getAgendar() {
		return agendar;
	}

	public void setAgendar(Agendar agendar) {
		this.agendar = agendar;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	

}
