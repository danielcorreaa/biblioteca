package org.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.biblioteca.modelo.Editora;
import org.biblioteca.util.ConexaoFactory;
import org.springframework.stereotype.Repository;


@Repository
public class EditoraDAO {
	
	public String salvar(Editora categoria){
		Connection  con = ConexaoFactory.getInstance().getConection();
		String msg = "";
		String sql = "Insert into editora values(?,?,?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, categoria.getCodigo());
			psmt.setString(2, categoria.getNome());
			psmt.setString(3, categoria.getNacionalidade());
			psmt.setString(4, categoria.getEndereco());
			psmt.setString(5, categoria.getContato());			
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
	
	public List<Editora> listarEditoras(){
		List<Editora> editoras = new ArrayList<>();
		Connection  con = ConexaoFactory.getInstance().getConection();
		String sql = "Select * from editora";
		try {
			Statement psmt = con.createStatement();
			ResultSet result = psmt.executeQuery(sql);
			while(result.next()){
				Editora editora = new Editora();
				editora.setCodigo(result.getInt("cod_editora"));
				editora.setNome(result.getString("nome_editora"));
				editora.setNacionalidade(result.getString("nacionalidade_editora"));
				editora.setEndereco(result.getString("end_ediotra"));
				editora.setContato(result.getString("contato_editora"));
				editoras.add(editora);
			}
			result.close();
			psmt.close();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return editoras;
		
	}

	public String excluir(Integer id) {
		Connection  con = ConexaoFactory.getInstance().getConection();
		String msg = "";
		String sql = " delete from editora where cod_editora = ?";
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
