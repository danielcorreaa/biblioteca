package org.biblioteca.modelo;

public class Livro {

	private Integer codigo;
	private String titulo;
	private String tituloOriginal;
	private String idiomaOriginal;
	private String situacao;
	private Editora editora;
	private Categoria categoria;

	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the tituloOriginal
	 */
	public String getTituloOriginal() {
		return tituloOriginal;
	}

	/**
	 * @param tituloOriginal
	 *            the tituloOriginal to set
	 */
	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	/**
	 * @return the idiomaOriginal
	 */
	public String getIdiomaOriginal() {
		return idiomaOriginal;
	}

	/**
	 * @param idiomaOriginal
	 *            the idiomaOriginal to set
	 */
	public void setIdiomaOriginal(String idiomaOriginal) {
		this.idiomaOriginal = idiomaOriginal;
	}

	/**
	 * @return the situacao
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao
	 *            the situacao to set
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	/**
	 * @return the editora
	 */
	public Editora getEditora() {
		return editora;
	}

	/**
	 * @param editora
	 *            the editora to set
	 */
	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getEditoraNome(){
		return editora.getNome();
	}
	
	public String getCategoriaDescricao(){
		return categoria.getDescricao();
	}

}
