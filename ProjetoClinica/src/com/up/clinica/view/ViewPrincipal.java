package com.up.clinica.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	public ViewPrincipal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void exibirPainel(IPainelInterfaceClinica painel) {
		this.setTitle(painel.getNomePainel());
		this.setPreferredSize(painel.getDimensaoPainel());
		this.setContentPane(painel.getPainel());
		this.pack();
	}

	public void exibirMensagemErro(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}
}