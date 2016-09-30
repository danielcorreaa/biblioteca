package com.projprime.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data {
	
	private Date data;
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
	
	

}
