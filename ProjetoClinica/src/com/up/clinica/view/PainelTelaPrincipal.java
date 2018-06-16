package com.up.clinica.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class PainelTelaPrincipal implements IPainelInterfaceClinica{

	private static final Dimension DIMENSAO_PAINEL = new Dimension(200,200);
	private static final String NOME_JANELA = "Clínica Veterinária UP";
	
	private JButton btnAnimais = new JButton("Animais");
	private JButton btnEspecies = new JButton("Espécies");
	private JPanel conteudoMenuPrincipal;
	
	public PainelTelaPrincipal() {
		conteudoMenuPrincipal = new JPanel();
		SpringLayout layout = new SpringLayout();

		conteudoMenuPrincipal.setLayout(layout);
		conteudoMenuPrincipal.add(btnAnimais);
		conteudoMenuPrincipal.add(btnEspecies);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnimais, 0, SpringLayout.HORIZONTAL_CENTER, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.NORTH, btnAnimais, 5, SpringLayout.NORTH, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnEspecies, 0, SpringLayout.HORIZONTAL_CENTER, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.NORTH, btnEspecies, 40, SpringLayout.NORTH, conteudoMenuPrincipal);
	}
	
	@Override
	public JPanel getPainel() {
		return conteudoMenuPrincipal;
	}

	@Override
	public Dimension getDimensaoPainel() {
		return DIMENSAO_PAINEL;
	}
	
	public void addBtnAnimaisListener(ActionListener animaisListener) {
		btnAnimais.addActionListener(animaisListener);
	}
	
	public void addBtnEspeciesListener(ActionListener animaisListener) {
		btnEspecies.addActionListener(animaisListener);
	}

	@Override
	public String getNomePainel() {
		return NOME_JANELA;
	}
}