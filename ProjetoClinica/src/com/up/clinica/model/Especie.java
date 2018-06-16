package com.up.clinica.model;

public class Especie {
	private Long id;
	private String nome;
	private String descricao;
	private TipoAnimal tipoAnimal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}
	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
}