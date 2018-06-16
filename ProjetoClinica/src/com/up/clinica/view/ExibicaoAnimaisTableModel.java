package com.up.clinica.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.up.clinica.model.Animal;

public class ExibicaoAnimaisTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	private static final int NUM_COLUNAS_ANIMAL = 4;

	private List<Animal> animaisTabela;

	public ExibicaoAnimaisTableModel() {
	}
	public ExibicaoAnimaisTableModel(List<Animal> animais) {
		animaisTabela = animais;
	}

	public List<Animal> getAnimaisTabela() {
		return animaisTabela;
	}

	public void setAnimaisTabela(List<Animal> animaisTabela) {
		this.animaisTabela = animaisTabela;
	}
	
	@Override
	public String getColumnName(int coluna) {
		switch(coluna) {
			case 0:
				return "Identificador";
			case 1:
				return "Nome";
			case 2:
				return "Nascimento";
			case 3:
				return "Espécie";
			default:
				throw new RuntimeException("Solicitada uma coluna no JTable que não existe");
		}
	}

	@Override
	public int getColumnCount() {
		return NUM_COLUNAS_ANIMAL;
	}

	@Override
	public int getRowCount() {
		if(animaisTabela!=null)
			return animaisTabela.size();
		else
			return 0;
	}
	
	@Override
	public Object getValueAt(int linha, int coluna) {
		switch(coluna) {
			case 0:
				return animaisTabela.get(linha).getId();
			case 1:
				return animaisTabela.get(linha).getNome();
			case 2:
				return animaisTabela.get(linha).getNascimento();
			case 3:
				return animaisTabela.get(linha).getEspecie().getNome();
			default:
				throw new RuntimeException("Coluna inválida");
		}
	}
	
	public Animal getAnimalSelecionado(int numLinha) {
		if(numLinha>=0 && numLinha < animaisTabela.size())
			return animaisTabela.get(numLinha);
		else
			return null;
	}
}