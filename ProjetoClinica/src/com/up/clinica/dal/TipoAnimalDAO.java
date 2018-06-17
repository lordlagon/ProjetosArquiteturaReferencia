package com.up.clinica.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.up.clinica.model.TipoAnimal;

public class TipoAnimalDAO extends AbstractDAO<TipoAnimal, String>{

	@Override
	protected PreparedStatement criarStatementBuscar(Connection conexao, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement criarStatementRemover(Connection conexao, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement criarStatementListar(Connection conexao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected TipoAnimal parseObjeto(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	protected void removerComRelacionamentos(Connection conexao, TipoAnimal objeto)  {
		PreparedStatement statement = null;				
		try {
			conexao.setAutoCommit(false);
			statement = conexao.prepareStatement("DELETE FROM ANIMAL WHERE ESPECIE_ID = (SELECT ID FROM ESPECIE WHERE TIPO_ANIMAL_ACRONIMO = ?)");
			statement.setString(1, objeto.getAcronimo());
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				
			}
			
			statement = conexao.prepareStatement("DELETE FROM ESPECIE WHERE TIPO_ANIMAL_ACRONIMO=?");
			statement.setString(1, objeto.getAcronimo());
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				
			}
			statement = conexao.prepareStatement("DELETE FROM TIPO_ANIMAL WHERE ACRONIMO=?");
			statement.setString(1, objeto.getAcronimo());
			
			conexao.commit();
		} catch (Exception e) {
			if(conexao != null)
				try {
					conexao.rollback();
				} catch (SQLException e1) {
					
				}
			
		} finally {
			try {
				if(conexao != null)
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