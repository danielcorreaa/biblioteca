package com.projprime.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.projprime.dao.PacienteDAO;
import com.projprime.modelo.Paciente;
@FacesConverter( forClass = Paciente.class)
public class PacienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) throws ConverterException {		
		PacienteDAO dao = new PacienteDAO();
		Paciente paciente = null;
		try{
			paciente = dao.getId(Integer.getInteger(id));
		}catch (Exception e) {
			throw new ConverterException("Erro ao buscar paciente por id");
		}
		
		return paciente;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {		
		return  String.valueOf(((Paciente) obj).getId());
	}

}
