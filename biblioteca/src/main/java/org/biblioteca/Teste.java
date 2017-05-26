package org.biblioteca;

import org.biblioteca.dao.AutorDAO;

public class Teste {
	
	public static void main(String[] args) {
		/*Autor autor = new Autor();
		autor.setCodigo(gerarCodigo());
		autor.setNome("Daniel Correa");
		autor.setNacionalidade("Brasileiro");*/
		
		AutorDAO dao = new AutorDAO();
		String msg = dao.excluir(149514517);
		System.out.println(msg);
	}
	
	public static Integer gerarCodigo(){
		Long codigo = System.currentTimeMillis();
		Integer retorno = (int) (codigo / 10000);
		return retorno;
	}

}
