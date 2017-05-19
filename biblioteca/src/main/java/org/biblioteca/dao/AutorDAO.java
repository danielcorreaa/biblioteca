package org.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.biblioteca.modelo.Autor;
import org.biblioteca.util.ConexaoFactory;
import org.springframework.stereotype.Repository;


@Repository
public class AutorDAO {
	
	public String salvar(Autor autor){
		Connection  con = ConexaoFactory.getInstance().getConection();
		String msg = "";
		String sql = "Insert into autor values(?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, autor.getCodigo());
			psmt.setString(2, autor.getNome());
			psmt.setString(3, autor.getNacionalidade());
			psmt.execute();
			msg = "Salvo com sucesso!";
			psmt.close();
			con.close();
		} catch (SQLException e) {
			msg = "Falha ao salvar "+ e.getMessage();
			e.printStackTrace();
		}
		return msg;
	}
	
	public List<Autor> listarAutores(){
		List<Autor> autores = new ArrayList<>();
		Connection  con = ConexaoFactory.getInstance().getConection();
		String sql = "Select * from autor";
		try {
			Statement psmt = con.createStatement();
			ResultSet result = psmt.executeQuery(sql);
			while(result.next()){
				Autor autor = new Autor();
				autor.setCodigo(result.getInt("cod_autor"));
				autor.setNome(result.getString("nome_autor"));
				autor.setNacionalidade(result.getString("nacionalidade_autor"));
				autores.add(autor);
			}
			result.close();
			psmt.close();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return autores;
		
	}

	public String excluir(Integer id) {
		Connection  con = ConexaoFactory.getInstance().getConection();
		String msg = "";
		String sql = " delete from autor where cod_autor = ?";
		try {
			PreparedStatement stmp = con.prepareStatement(sql);
			stmp.setInt(1, id);
			stmp.execute();
			msg = "Excluido com sucesso!";
			stmp.close();
			con.close();
		} catch (SQLException e) {
			msg = "Falha ao excluir! "+e.getMessage();
			e.printStackTrace();
		}
		return msg;
	}
}
