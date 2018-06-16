package com.up.clinica.view;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.up.clinica.model.Especie;

public class ComboBoxEspeciesModel extends AbstractListModel<Especie> implements ComboBoxModel<Especie>{

	private static final long serialVersionUID = 1L;
	
	private List<Especie> especies;
	private Especie especieSelecionada;
	
	public ComboBoxEspeciesModel() {
	}
	
	public ComboBoxEspeciesModel(List<Especie> especies) {
		this.especies = especies;
	}
	
	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
		if(especies.size()>0)
			especieSelecionada = especies.get(0);
	}

	@Override
	public Especie getElementAt(int arg0) {
		return especies.get(arg0);
	}

	@Override
	public int getSize() {
		if(especies!=null)
			return especies.size();
		return 0;
	}

	@Override
	public Especie getSelectedItem() {
		return especieSelecionada;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		especieSelecionada = (Especie)anItem;
	}
}
