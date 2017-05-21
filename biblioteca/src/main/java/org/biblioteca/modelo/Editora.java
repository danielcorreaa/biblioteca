package org.biblioteca.modelo;

public class Editora {

	private Integer codigo;
	private String nome;
	private String nacionalidade;
	private String endereco;
	private String contato;

	public Editora() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer cod_editora) {
		this.codigo = cod_editora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

}
