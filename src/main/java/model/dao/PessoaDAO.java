package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.vacinacao.Pessoa;

public class PessoaDAO {
	
	public Pessoa inserir(Pessoa novaPessoa) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PESSOA (NOME, DATANASCIMENTO, SEXO, CPF, TIPOPESSOA, NOTAVACINA) "
				+ " VALUES (?,?,?,?,?,?)";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			query.setString(1, novaPessoa.getNome());
			query.setString(2, novaPessoa.getDataNascimento());
			query.setString(3, novaPessoa.getSexo());
			query.setString(4, novaPessoa.getCpf());
			query.setInt(5, novaPessoa.getTipoPessoa().getValor());
			query.setDouble(6, novaPessoa.getNotaVacina());
			query.execute();
			
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novaPessoa.setId(resultado.getInt(1));
			}
		} catch (SQLException e){
			System.out.println("Erro ao inserir usuário"
					+ "\nCausa " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return novaPessoa;
	}

}
