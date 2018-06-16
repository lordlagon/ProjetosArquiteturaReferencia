package com.up.clinica.view;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import com.up.clinica.model.Especie;

public class ComboboxEspeciesRenderer extends DefaultListCellRenderer {
	
	private static final long serialVersionUID = 1L;

	@Override
    public Component getListCellRendererComponent(JList<?> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Especie) {
        	Especie e = (Especie) value;
            setText(e.getNome());
        }
        return this;
    }
}