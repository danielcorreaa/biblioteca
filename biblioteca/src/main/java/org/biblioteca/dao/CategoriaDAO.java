package org.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.biblioteca.modelo.Categoria;
import org.biblioteca.util.ConexaoFactory;
import org.springframework.stereotype.Repository;


@Repository
public class CategoriaDAO {
	
	public String salvar(Categoria categoria){
		Connection  con = ConexaoFactory.getInstance().getConection();
		String msg = "";
		String sql = "Insert into categoria_livro values(?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, categoria.getCodigo());
			psmt.setString(2, categoria.getDescricao());
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
	
	public List<Categoria> listarCategorias(){
		List<Categoria> categorias = new ArrayList<>();
		Connection  con = ConexaoFactory.getInstance().getConection();
		String sql = "Select * from categoria_livro";
		try {
			Statement psmt = con.createStatement();
			ResultSet result = psmt.executeQuery(sql);
			while(result.next()){
				Categoria categoria = new Categoria();
				categoria.setCodigo(result.getInt("cd_categ"));
				categoria.setDescricao(result.getString("descr_categ"));			
				categorias.add(categoria);
			}
			result.close();
			psmt.close();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return categorias;
		
	}

	public String excluir(Integer id) {
		Connection  con = ConexaoFactory.getInstance().getConection();
		String msg = "";
		String sql = " delete from categoria_livro where cd_categ = ?";
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
