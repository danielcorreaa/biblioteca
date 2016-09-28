package com.projprime.modelo;

import com.projprime.util.Data;

public class Paciente {

	private Integer id;
	private String nome;
	private Data data = new Data();

	public Paciente() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
