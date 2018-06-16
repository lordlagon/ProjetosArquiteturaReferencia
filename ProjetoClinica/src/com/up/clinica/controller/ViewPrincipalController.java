package com.up.clinica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.up.clinica.model.Animal;
import com.up.clinica.model.Especie;
import com.up.clinica.model.dao.AnimalDAO;
import com.up.clinica.model.dao.EspecieDAO;
import com.up.clinica.view.ViewCadastroAnimaisModal;
import com.up.clinica.view.PainelTelaAnimais;
import com.up.clinica.view.PainelTelaPrincipal;
import com.up.clinica.view.ViewPrincipal;

public class ViewPrincipalController {

	private AnimalDAO animalDAO = new AnimalDAO();
	private EspecieDAO especieDAO = new EspecieDAO();
	
	private SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/YYYY");
	
	private ViewPrincipal view;
	private ViewCadastroAnimaisModal viewCadastroAnimaisModal = new ViewCadastroAnimaisModal();
	private PainelTelaPrincipal painelTelaPrincipal = new PainelTelaPrincipal();
	private PainelTelaAnimais painelTelaAnimais = new PainelTelaAnimais();
	

	public ViewPrincipalController(ViewPrincipal view) {
		this.view = view;
		this.painelTelaPrincipal.addBtnAnimaisListener(new BtnAnimaisListener());
		this.painelTelaPrincipal.addBtnEspeciesListener(new BtnEspeciesListener());
		this.painelTelaAnimais.addBtnVoltarListener(new BtnVoltarListener());
		this.painelTelaAnimais.addBtnNovoListener(new BtnCadastrarAnimalListener());
		this.painelTelaAnimais.addBtnExcluirListener(new BtnExcluirAnimalListener());
		this.viewCadastroAnimaisModal.addBtnNovoListener(new BtnSalvarAnimalListener());
		
		view.exibirPainel(painelTelaPrincipal);
	}

	private class BtnAnimaisListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				atualizarListaAnimaisTelaAnimais();
				view.exibirPainel(painelTelaAnimais);
			}catch (Exception exception) {
				//TODO: Logar exceção
				view.exibirMensagemErro("Ocorreu um erro ao exibir animais");
			}
		}
	}
	
	private class BtnVoltarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.exibirPainel(painelTelaPrincipal);
		}
	}
	
	private class BtnEspeciesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.exibirMensagemErro("Funcionalidade não Implementada");
		}
	}
	
	private class BtnCadastrarAnimalListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				List<Especie> especies = especieDAO.listar();
				viewCadastroAnimaisModal.setEspecies(especies);
				viewCadastroAnimaisModal.limparCampos();
				viewCadastroAnimaisModal.renderizarJanela();
			}catch(Exception ex) {
				//TODO: Logar exceção
				view.exibirMensagemErro("Ocorreu um erro ao cadastrar o animal.");
			}
		}
	}
	
	private class BtnSalvarAnimalListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Animal a = new Animal();
				a.setNome(viewCadastroAnimaisModal.getNomeAnimal());
				try {
					a.setNascimento(formatoData.parse(viewCadastroAnimaisModal.getStrNascimentoAnimal()));
				}catch (ParseException pe) {
					view.exibirMensagemErro("Formato de data inválido!");
					return;
				}
				a.setEspecie(viewCadastroAnimaisModal.getEspecieAnimal());
				animalDAO.persistir(a);
				atualizarListaAnimaisTelaAnimais();
				viewCadastroAnimaisModal.setVisible(false);
			}catch(Exception ex) {
				//TODO: Logar exceção
				view.exibirMensagemErro("Ocorreu um erro ao cadastrar o animal");
			}
		}
	}
	
	private class BtnExcluirAnimalListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Animal a = painelTelaAnimais.getAnimalSelecionado();
				if(a == null) {
					view.exibirMensagemErro("Nenhum animal selecionado!");
					return;
				}
				animalDAO.remover(a.getId());
				atualizarListaAnimaisTelaAnimais();
			}catch(Exception ex) {
				//TODO: Logar exceção
				view.exibirMensagemErro("Ocorreu um erro ao excluir o animal");
			}
		}
	}
	
	private void atualizarListaAnimaisTelaAnimais() throws Exception{
		List<Animal> animais = animalDAO.listar();
		painelTelaAnimais.setAnimaisPainel(animais);
	}
}