package com.up.clinica.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import com.up.clinica.model.Animal;

public class PainelTelaAnimais implements IPainelInterfaceClinica {


	private static final Dimension DIMENSAO_PAINEL = new Dimension(400,400);
	private static final String NOME_JANELA = "Animais";
	
	private JButton btnVoltar = new JButton("Voltar");
	private JButton btnNovo = new JButton("Novo");
	private JButton btnExcluir = new JButton("Excluir");
	
	private JPanel conteudoManutencaoAnimais;
	private ExibicaoAnimaisTableModel modeloExibicaoAnimaisTabela;
	private JTable tabelaAnimais;

	public PainelTelaAnimais() {
		modeloExibicaoAnimaisTabela = new ExibicaoAnimaisTableModel();
		tabelaAnimais = new JTable(modeloExibicaoAnimaisTabela);

		conteudoManutencaoAnimais = new JPanel();
		SpringLayout layoutManutencaoAnimais = new SpringLayout();
		conteudoManutencaoAnimais.setLayout(layoutManutencaoAnimais);
		conteudoManutencaoAnimais.add(tabelaAnimais);
		conteudoManutencaoAnimais.add(btnVoltar);
		conteudoManutencaoAnimais.add(btnNovo);
		conteudoManutencaoAnimais.add(btnExcluir);

		layoutManutencaoAnimais.putConstraint(SpringLayout.NORTH, tabelaAnimais, 5, SpringLayout.NORTH,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.WEST, tabelaAnimais, 5, SpringLayout.WEST,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.EAST, tabelaAnimais, -100, SpringLayout.EAST,
				conteudoManutencaoAnimais);
		
		layoutManutencaoAnimais.putConstraint(SpringLayout.NORTH, btnNovo, 5, SpringLayout.NORTH,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.EAST, btnNovo, -5, SpringLayout.EAST,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.NORTH, btnExcluir, 40, SpringLayout.NORTH,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.EAST, btnExcluir, -5, SpringLayout.EAST,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.NORTH, btnVoltar, 100, SpringLayout.NORTH,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.EAST, btnVoltar, -5, SpringLayout.EAST,
				conteudoManutencaoAnimais);
	}
	
	public void setAnimaisPainel(List<Animal> animaisParaExibir) {
		modeloExibicaoAnimaisTabela.setAnimaisTabela(animaisParaExibir);
		tabelaAnimais.updateUI();
	}
	
	@Override
	public JPanel getPainel() {
		return conteudoManutencaoAnimais;
	}

	@Override
	public Dimension getDimensaoPainel() {
		return DIMENSAO_PAINEL;
	}

	@Override
	public String getNomePainel() {
		return NOME_JANELA;
	}
	
	public Animal getAnimalSelecionado() {
		return modeloExibicaoAnimaisTabela.getAnimalSelecionado(tabelaAnimais.getSelectedRow()) ;
	}
	
	public void addBtnNovoListener(ActionListener voltarListener) {
		btnNovo.addActionListener(voltarListener);
	}
	
	public void addBtnVoltarListener(ActionListener voltarListener) {
		btnVoltar.addActionListener(voltarListener);
	}
	
	public void addBtnExcluirListener(ActionListener excluirListener) {
		btnExcluir.addActionListener(excluirListener);
	}
}
