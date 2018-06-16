package com.up.clinica.model;

import java.time.DateTimeException;
import java.util.Date;

public class Animal {
	private Long id;
	private String nome;
	private Date nascimento;
	private Especie especie;
	
	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public Date getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(Date nascimento) throws DateTimeException{
		if(nascimento != null && (new Date()).compareTo(nascimento)<0)
			throw new DateTimeException("A data/hora de nascimento do animal não pode ser maior que a atual");
		this.nascimento = nascimento;
	}
}