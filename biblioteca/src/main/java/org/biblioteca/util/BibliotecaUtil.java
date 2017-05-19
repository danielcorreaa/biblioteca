package org.biblioteca.util;

public class BibliotecaUtil {
	
	
	public static Integer gerarCodigo(){
		Long codigo = System.currentTimeMillis();
		Integer retorno = (int) (codigo / 10000);
		return retorno;
	}

}
