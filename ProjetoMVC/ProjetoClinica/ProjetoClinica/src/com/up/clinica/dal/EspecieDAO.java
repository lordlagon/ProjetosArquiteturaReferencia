package com.up.clinica.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.up.clinica.model.Animal;
import com.up.clinica.model.Especie;

public class EspecieDAO extends AbstractDAO<Especie, Long>{

	@Override
	protected void carregarChavesGeradasNoObjeto(ResultSet generatedKeys, Especie objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected PreparedStatement criarStatementPersistir(Connection conexao, Especie objeto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement criarStatementAtualizar(Connection conexao, Especie objeto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement criarStatementRemover(Connection conexao, Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void removerComRelacionamento(Long idEspecie) throws Exception {

		Connection con = null;
		PreparedStatement statementEspecie = null;
		PreparedStatement statementAnimal = null;
		ResultSet generatedKeys = null;
		Exception ultimaExcecao = null;

		try {
			con = ConnectionFactory.getConnection();
			statementAnimal = con.prepareStatement("DELETE FROM ANIMAL WHERE especie_id=?");
			statementAnimal.setLong(1, idEspecie);
			statementAnimal.executeUpdate();
			
			statementEspecie = con.prepareStatement("DELETE FROM ESPECIE WHERE id=?");
			statementEspecie.setLong(1, idEspecie);
			statementEspecie.executeUpdate();
			return;
		} catch (Exception e) {
			ultimaExcecao = e;
		} finally {
			try {
				if (generatedKeys != null)
					generatedKeys.close();
			} catch (SQLException e) {
				ultimaExcecao = e;
			}
			try {
				if (statementEspecie != null)
					statementEspecie.close();
				if (statementAnimal != null)
					statementAnimal.close();
			} catch (Exception e) {
				ultimaExcecao = e;
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				ultimaExcecao = e;
			}
		}
		throw ultimaExcecao;
	}

}