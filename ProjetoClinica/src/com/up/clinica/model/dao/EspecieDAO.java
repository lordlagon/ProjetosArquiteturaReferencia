package com.up.clinica.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
