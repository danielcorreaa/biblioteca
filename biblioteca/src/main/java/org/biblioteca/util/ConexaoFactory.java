package org.biblioteca.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexaoFactory {	
	
	private static ConexaoFactory conexaoFactory;	
	
	public static ConexaoFactory getInstance(){
		if(conexaoFactory == null){
			conexaoFactory = new ConexaoFactory();
		}
		return conexaoFactory;
	}
	
	private ConexaoFactory() {}

	public Connection getConection(){	
		Connection conection = null;
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String drive = "com.mysql.jdbc.Driver";
		try {
			 Class.forName(drive);
			 conection = DriverManager.getConnection(url, user, password);			 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conection;
	}
	
	public String verificarConexao(){
		if(getConection() == null) return "Falha ao conectar";		
		return "Conexão ok";
	}
	
	public static void main(String[] args) {
		ConexaoFactory factory = new ConexaoFactory();
		System.out.println(factory.verificarConexao());
	}

}
