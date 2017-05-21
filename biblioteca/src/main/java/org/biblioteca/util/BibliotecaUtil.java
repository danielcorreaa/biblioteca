package org.biblioteca.util;

public class BibliotecaUtil {
	
	
	public static Integer gerarCodigo(){
		Long codigo = System.currentTimeMillis();
		Integer retorno = (int) (codigo / 10000);
		return retorno;
	}
	
	public static Integer gerarCodigoMinimo(){
		Long codigo = System.currentTimeMillis();
		Integer retorno = (int) (codigo / 100000000);
		return retorno;
	}
	public static void main(String[] args) {
		System.out.println(gerarCodigoMinimo());
	}
}
