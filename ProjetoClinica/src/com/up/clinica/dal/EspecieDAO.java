package com.up.clinica.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.up.clinica.model.Especie;

public class EspecieDAO extends AbstractDAO<Especie, Long> {


	@Override
	protected PreparedStatement criarStatementListar(Connection conexao) throws Exception {
		return conexao.prepareStatement("select id,nome,descricao from especie");
	}

	@Override
	protected Especie parseObjeto(ResultSet rs) throws Exception {
		Especie e = new Especie();
		e.setId(rs.getLong(1));
		e.setNome(rs.getString(2));
		e.setDescricao(rs.getString(3));

		return e;
	}
	
	@Override
	protected PreparedStatement criarStatementBuscar(Connection conexao, Long id) throws Exception {
		PreparedStatement statement = conexao
				.prepareStatement("SELECT ID, NOME,DESCRICAO, TIPO_ANIMAL_ACRONIMO, WHERE id = ?");
		statement.setLong(1, id);
		return statement;
	}

	@Override
	protected PreparedStatement criarStatementAtualizar(Connection conexao, Especie objeto) throws Exception {
		PreparedStatement statement = conexao
				.prepareStatement("UPDATE ESPECIE SET nome=?, DESCRICAO=?,TIPO_ANIMAL_ACRONIMO=? WHERE id=?");
		statement.setString(1, objeto.getNome());
		statement.setString(3, objeto.getDescricao());
		statement.setString(4, objeto.getTipoAnimal().getAcronimo());
		statement.setLong(4, objeto.getId());

		return statement;

	}

	@Override
	protected PreparedStatement criarStatementPersistir(Connection conexao, Especie objeto) throws Exception {
		PreparedStatement statement = conexao.prepareStatement(
				"INSERT INTO ESPECIE (NOME,DESCRICAO,TIPO_ANIMAL_ACRONIMO) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, objeto.getNome());
		if (objeto.getNascimento() != null)
			statement.setDate(2, new java.sql.Date(objeto.getNascimento().getTime()));
		else
			statement.setNull(2, java.sql.Types.DATE);
		statement.setLong(3, objeto.getEspecie().getId());
		return statement;
	}

	
	
	@Override
	protected void carregarChavesGeradasNoObjeto(ResultSet generatedKeys, Especie objeto) throws Exception {
		// TODO Auto-generated method stub

	}

	protected void removerComRelacionamentos(Connection conexao, Long id) {
		PreparedStatement statement = null;
		try {
			conexao.setAutoCommit(false);
			statement = conexao.prepareStatement("DELETE FROM ANIMAL WHERE ESPECIE_ID=?");
			statement.setLong(1, id);
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}

			statement = conexao.prepareStatement("DELETE FROM ESPECIE WHERE ID=?");
			statement.setLong(1, id);
			conexao.commit();
		} catch (Exception e) {
			if (conexao != null)
				try {
					conexao.rollback();
				} catch (SQLException e1) {

				}

		} finally {
			try {
				if (conexao != null)
					conexao.setAutoCommit(true);
			} catch (SQLException e) {

			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}
			try {
				if (conexao != null)
					conexao.close();
			} catch (Exception e) {

			}

		}

	}

}
