package org.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.biblioteca.modelo.Livro;
import org.biblioteca.util.ConexaoFactory;
import org.springframework.stereotype.Repository;


@Repository
public class LivroDAO {
	
	public String salvar(Livro livro){
		Connection  con = ConexaoFactory.getInstance().getConection();
		String msg = "";
		String sql = "Insert into livro values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, livro.getCodigo());
			psmt.setString(2, livro.getTitulo());
			psmt.setString(3, livro.getTituloOriginal());
			psmt.setString(4, livro.getIdiomaOriginal());
			psmt.setString(5, livro.getSituacao());
			psmt.setInt(6, livro.getEditora().getCodigo());	
			psmt.setInt(7, livro.getCategoria().getCodigo());	
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
	
	public List<Livro> listaLivros(){
		List<Livro> livros = new ArrayList<>();
		Connection  con = ConexaoFactory.getInstance().getConection();
		String sql = "Select * from livro";
		try {
			Statement psmt = con.createStatement();
			ResultSet result = psmt.executeQuery(sql);
			while(result.next()){
				Livro livro = new Livro();
				livro.setCodigo(result.getInt("cod_livro"));
				livro.setTitulo(result.getString("titulo_livro"));
				livro.setTituloOriginal(result.getString("titulo_original"));
				livro.setIdiomaOriginal(result.getString("idioma_original"));
				livro.setSituacao(result.getString("situacao_livro"));
				livro.getEditora().setCodigo(result.getInt("cod_editora"));
				livro.getCategoria().setCodigo(result.getInt("cod_categ"));
				livros.add(livro);
			}
			result.close();
			psmt.close();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return livros;		
	}

	public String excluir(Integer id) {
		Connection  con = ConexaoFactory.getInstance().getConection();
		String msg = "";
		String sql = " delete from livro where cod_livro = ?";
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
