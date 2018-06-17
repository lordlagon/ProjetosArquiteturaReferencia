package com.up.clinica.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.up.clinica.model.TipoAnimal;

public class TipoAnimalDAO extends AbstractDAO<TipoAnimal, String> {

	@Override
	protected PreparedStatement criarStatementBuscar(Connection conexao, String id) throws Exception {
		PreparedStatement statement = conexao
				.prepareStatement("SELECT ACRONIMO, NOME,DESCRICAO FROM tipo_animal WHERE acronimo = '?'");
		statement.setString(1, id);
		return statement;

	}

	@Override
	protected PreparedStatement criarStatementRemover(Connection conexao, String acronimo) throws Exception {
		PreparedStatement statement = conexao.prepareStatement("DELETE FROM TIPO_ANIMAL WHERE acronimo='?'");
		statement.setString(1, acronimo);
		return statement;

	}

	@Override
	protected void carregarChavesGeradasNoObjeto(ResultSet generatedKeys, TipoAnimal objeto) throws Exception {
		objeto.setAcronimo(generatedKeys.getString(1));

	}

	@Override
	protected PreparedStatement criarStatementPersistir(Connection conexao, TipoAnimal objeto) throws Exception {
		PreparedStatement statement = conexao.prepareStatement(
				"INSERT INTO TIPO_ANIMAL (ACRONIMO,NOME,DESCRICAO) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, objeto.getAcronimo());
		statement.setString(2, objeto.getNome());
		statement.setString(3, objeto.getDescricao());
		return statement;
	}

	@Override
	protected PreparedStatement criarStatementAtualizar(Connection conexao, TipoAnimal objeto) throws Exception {
		PreparedStatement statement = conexao
				.prepareStatement("UPDATE tipo_animal SET acronimo=?, nome=?,descricao=? WHERE acronimo=?");
		statement.setString(1, objeto.getAcronimo());
		statement.setString(2, objeto.getNome());
		statement.setString(3, objeto.getDescricao());

		return statement;
	}

	@Override
	protected PreparedStatement criarStatementListar(Connection conexao) throws Exception {
		return conexao.prepareStatement("select acronimo,nome,descricao from tipo_animal");
	}

	@Override
	protected TipoAnimal parseObjeto(ResultSet rs) throws Exception {
		TipoAnimal t = new TipoAnimal();
		t.setAcronimo(rs.getString(1));
		t.setNome(rs.getString(2));
		t.setDescricao(rs.getString(3));

		return t;

	}

	protected void removerComRelacionamentos(String acronimo) {
		PreparedStatement statementAnimal = null;
		PreparedStatement statementEspecie = null;
		PreparedStatement statementTipoAnimal = null;
		Connection conexao = null;
		try {
			conexao = ConnectionFactory.getConnection();
			conexao.setAutoCommit(false);
			statementAnimal = conexao.prepareStatement("DELETE FROM ANIMAL WHERE ESPECIE_ID = (SELECT ID FROM ESPECIE WHERE TIPO_ANIMAL_ACRONIMO = ?)");
			statementAnimal.setString(1, acronimo);
			statementAnimal.executeUpdate();

			statementEspecie = conexao.prepareStatement("DELETE FROM ESPECIE WHERE TIPO_ANIMAL_ACRONIMO=?");
			statementEspecie.setString(1, acronimo);
			statementEspecie.executeUpdate();

			statementTipoAnimal = conexao.prepareStatement("DELETE FROM TIPO_ANIMAL WHERE ACRONIMO=?");
			statementTipoAnimal.setString(1, acronimo);
			statementTipoAnimal.executeUpdate();

			conexao.commit();
			return;
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
				if (statementTipoAnimal != null)
					statementTipoAnimal.close();
			} catch (Exception e) {

			}
			try {
				if (statementAnimal != null)
					statementAnimal.close();
			} catch (Exception e) {

			}
			try {
				if (statementEspecie != null)
					statementEspecie.close();
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