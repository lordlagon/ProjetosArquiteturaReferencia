package com.up.clinica.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.up.clinica.model.Especie;

public class ViewCadastroAnimaisModal extends JDialog{

	private static final long serialVersionUID = 1L;
	private static final String NOME_JANELA = "Cadastro de Animais";
	private static final int TABULACAO = 190;
	
	private JPanel painel = new JPanel();
	private JTextField nomeAnimalTextField = new JTextField();
	private JTextField nascimentoAnimalTextField = new JTextField();
	private JLabel lblNome = new JLabel("Nome");
	private JLabel lblNascimento = new JLabel("Nascimento (dd/MM/aaaa)");
	private JLabel lblEspecie = new JLabel("Espécie");
	private ComboBoxEspeciesModel comboboxModel = new ComboBoxEspeciesModel();
	private JComboBox<Especie> comboboxEspecie = new JComboBox<Especie>(comboboxModel);
	private JButton btnSalvar = new JButton("Salvar");
	
	public ViewCadastroAnimaisModal() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		SpringLayout layout = new SpringLayout();
		painel.setLayout(layout);
		painel.add(nomeAnimalTextField);
		painel.add(lblNome);
		painel.add(lblNascimento);
		painel.add(nascimentoAnimalTextField);
		painel.add(comboboxEspecie);
		painel.add(lblEspecie);
		painel.add(btnSalvar);
		
		comboboxEspecie.setRenderer(new ComboboxEspeciesRenderer());
		
		layout.putConstraint(SpringLayout.NORTH, nomeAnimalTextField, 5, SpringLayout.NORTH,
				painel);
		layout.putConstraint(SpringLayout.WEST, nomeAnimalTextField, TABULACAO, SpringLayout.WEST,
				painel);
		layout.putConstraint(SpringLayout.EAST, nomeAnimalTextField, -5, SpringLayout.EAST,
				painel);
		layout.putConstraint(SpringLayout.WEST, lblNome, 5, SpringLayout.WEST,
				painel);
		layout.putConstraint(SpringLayout.NORTH, lblNome, 5, SpringLayout.NORTH,
				painel);
		
		layout.putConstraint(SpringLayout.NORTH, nascimentoAnimalTextField, 40, SpringLayout.NORTH,
				painel);
		layout.putConstraint(SpringLayout.WEST, nascimentoAnimalTextField, TABULACAO, SpringLayout.WEST,
				painel);
		layout.putConstraint(SpringLayout.EAST, nascimentoAnimalTextField, -5, SpringLayout.EAST,
				painel);
		layout.putConstraint(SpringLayout.WEST, lblNascimento, 5, SpringLayout.WEST,
				painel);
		layout.putConstraint(SpringLayout.NORTH, lblNascimento, 40, SpringLayout.NORTH,
				painel);
		
		layout.putConstraint(SpringLayout.NORTH, comboboxEspecie, 75, SpringLayout.NORTH,
				painel);
		layout.putConstraint(SpringLayout.WEST, comboboxEspecie, TABULACAO, SpringLayout.WEST,
				painel);
		layout.putConstraint(SpringLayout.EAST, comboboxEspecie, -5, SpringLayout.EAST,
				painel);
		layout.putConstraint(SpringLayout.WEST, lblEspecie, 5, SpringLayout.WEST,
				painel);
		layout.putConstraint(SpringLayout.NORTH, lblEspecie, 75, SpringLayout.NORTH,
				painel);
		
		layout.putConstraint(SpringLayout.NORTH, btnSalvar, 110, SpringLayout.NORTH,
				painel);
		layout.putConstraint(SpringLayout.EAST, btnSalvar, -5, SpringLayout.EAST,
				painel);
		
		
		this.setTitle(NOME_JANELA);
		this.setContentPane(painel);
		this.setModal(true);
	}
	
	public String getNomeAnimal() {
		return nomeAnimalTextField.getText();
	}
	
	public String getStrNascimentoAnimal() {
		return nascimentoAnimalTextField.getText();
	}
	
	public Especie getEspecieAnimal() {
		return (Especie)comboboxEspecie.getSelectedItem();
	}
	
	public void setEspecies(List<Especie> especies) {
		comboboxModel.setEspecies(especies);
	}
	
	public void renderizarJanela() {
		this.setBounds(400, 200, 400, 200);
		this.setVisible(true);
		this.pack();
	}
	
	public void limparCampos() {
		this.nomeAnimalTextField.setText("");
		this.nascimentoAnimalTextField.setText("");
		this.comboboxEspecie.setSelectedIndex(0);
	}
	
	public void addBtnNovoListener(ActionListener voltarListener) {
		btnSalvar.addActionListener(voltarListener);
	}
}