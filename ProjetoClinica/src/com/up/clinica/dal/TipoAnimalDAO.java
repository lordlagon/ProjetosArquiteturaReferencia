package com.up.clinica.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected PreparedStatement criarStatementPersistir(Connection conexao, TipoAnimal objeto) throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	
	
}