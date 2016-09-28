package com.projprime.bean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.projprime.modelo.Agendar;
import com.projprime.util.Data;

@ManagedBean
@ViewScoped
public class AgendarBean implements Serializable{
	
	private static final long serialVersionUID = -2572141871554221745L;
	private ScheduleModel eventModel;
	private Agendar agendar;
	private ScheduleEvent event = new DefaultScheduleEvent();
	
	public AgendarBean() {		
		super();
		agendar = new Agendar();
	}

	@PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
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

	public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        agendar.setDataConsulta(new Data());
    }
	
	

}
