package com.projprime.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table()
public class Data implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date data;
	@Transient
	private static String PATTERN = "dd/MM/yyyy";
	
	public int getidade(){
		int idade;
		int ano;
		int mes;
		int dia;
		Date dataAtual = new Date();
		Calendar nacimento = Calendar.getInstance();
		Calendar atual = Calendar.getInstance();
		nacimento.setTime(data);
		atual.setTime(dataAtual);
		ano = atual.get(Calendar.YEAR)  -  nacimento.get(Calendar.YEAR);
		mes = atual.get(Calendar.MONTH) - nacimento.get(Calendar.MONTH);
		dia = atual.get(Calendar.DAY_OF_MONTH) - nacimento.get(Calendar.DAY_OF_MONTH);
		idade = calcularIdade(dia,mes,ano);
		return idade;
	}

	private int calcularIdade(int dia, int mes, int ano) {
		int retorno = ano;
		if(dia < 0 && mes == 0){
			retorno = ano -1;
		}else if(mes < 0){
			retorno = ano -1;
		}				
		return retorno;
	}
	
	public String dataFormatada(){
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		String retorno = sdf.format(data);
		return retorno;
	}
	
	public Date stringforDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		try {
			data = sdf.parse(date);
		} catch (ParseException e) {
			data = new Date();
		}
		return data;
	}
	
	public Date objToDate(Object obj){
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		String dataString = sdf.format(obj);
		try {
			data = sdf.parse(dataString);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		return data;
	}
	
	public Date somarUmaHora(){		
		data.setHours(1);
		return data;
	}

	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Data(Date data) {
		super();
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
