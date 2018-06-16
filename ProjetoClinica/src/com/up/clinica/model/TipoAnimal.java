package com.up.clinica.model;

public class TipoAnimal {
	private String acronimo;
	private String nome;
	private String descricao;
	
	
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) throws Exception {
		if (acronimo == null || acronimo.isEmpty())
			throw new Exception("O Acronimo não pode ser vazio.");
		if(acronimo.length()>3)
			throw new Exception("O Acronimo não pode ter mais de 3 caracteres.");
		this.acronimo = acronimo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception{
		if(nome == null || nome.isEmpty())
			throw new Exception("O nome não pode ser vazio.");
		if(nome.length()>50)
			throw new Exception("O nome não pode ter mais de 50 caracteres.");
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
