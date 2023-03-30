package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.telefonia.Telefone;

public class TelefoneDAO {
	
	public Telefone inserir(Telefone novoTelefone) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO TELEFONE (DDD, NUMERO, ATIVO, MOVEL) "
				+ " VALUES (?,?,?,?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			query.setString(1, novoTelefone.getDdd());
			query.setString(2, novoTelefone.getNumero());
			query.setBoolean(3, novoTelefone.isAtivo());
			query.setBoolean(4, novoTelefone.isMovel());
			query.execute();

			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novoTelefone.setId(resultado.getInt(1));				
			}
		} catch (SQLException e){
			System.out.println("Erro ao inserir Telefone. "
					+ "\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return novoTelefone;
		
	}
	
	public boolean atualizar(Telefone telefoneEditado) {
		boolean atualizouTelefone = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE TELEFONE "
					+ " SET DDD = ?, NUMERO = ?, ATIVO = ?, MOVEL = ? "
					+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, telefoneEditado.getDdd());
			query.setString(2, telefoneEditado.getNumero());
			query.setBoolean(3, telefoneEditado.isAtivo());
			query.setBoolean(4, telefoneEditado.isMovel());
			query.setInt(5, telefoneEditado.getId());
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			
			if(quantidadeLinhasAtualizadas > 0) {
				atualizouTelefone = true;
			}
			
		} catch(SQLException e){
			System.out.println("Erro ao atualizar telefone."
								+"\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return atualizouTelefone;
	}
	
	public Telefone consultarTelefoneId(int id) {
		Telefone telefoneConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM TELEFONE "
				+ " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				telefoneConsultado = new Telefone();
				telefoneConsultado.setId(resultado.getInt("id"));
				telefoneConsultado.setDdd(resultado.getString("ddd"));
				telefoneConsultado.setNumero(resultado.getString("numero"));
				telefoneConsultado.setAtivo(resultado.getBoolean("ativo"));
				telefoneConsultado.setMovel(resultado.getBoolean("movel"));
			
			}
		} catch (SQLException e){
			System.out.println("Erro ao buscar telefone com id: " + id
					+ "\nCausa: " + e.getMessage());
		}
		return telefoneConsultado;
	}
	
	public boolean excluirTelefone(int id) {
		boolean excluiu = false;
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM TELEFONE "
				+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			int qtdLinhasAtualizadas = query.executeUpdate();
			excluiu = qtdLinhasAtualizadas > 0;
		} catch (SQLException e){
			System.out.println("Erro ao excluir telefone. "
					+ "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return excluiu;
	}
	
	public List<Telefone> consultarTodos() {
		List<Telefone> telefones = new ArrayList<Telefone>();
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM TELEFONE ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				Telefone telefoneConsultado = converterDeResultSetParaEntidade(resultado);
				telefones.add(telefoneConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os telefones" 
								+ "\n Causa: " + e.getMessage());	
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return telefones;
	}
	
	private Telefone converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Telefone telefoneConsultado = new Telefone(); 
		telefoneConsultado.setId(resultado.getInt("id"));
		telefoneConsultado.setIdCliente(resultado.getInt("id_cliente"));
		telefoneConsultado.setDdd(resultado.getString("ddd"));
		telefoneConsultado.setNumero(resultado.getString("numero"));
		telefoneConsultado.setAtivo(resultado.getBoolean("ativo"));
		telefoneConsultado.setMovel(resultado.getBoolean("movel"));
		return telefoneConsultado;
	}
	
	public List<Telefone> consultarPorIdCliente(Integer id) {
		List<Telefone> telefones = new ArrayList<Telefone>();
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM TELEFONE "
				+ " WHERE ID_CLIENTE = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				Telefone telefoneConsultado = converterDeResultSetParaEntidade(resultado);
				telefones.add(telefoneConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os telefones do cliente informado" 
								+ "\n Causa: " + e.getMessage());	
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return telefones;
	}

}
