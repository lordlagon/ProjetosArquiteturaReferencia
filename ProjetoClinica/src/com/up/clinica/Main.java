package com.up.clinica;

import com.up.clinica.controller.ViewPrincipalController;
import com.up.clinica.view.ViewPrincipal;

public class Main {

	public static void main(String[] args) {
		ViewPrincipal view = new ViewPrincipal();
		ViewPrincipalController controller = 
				new ViewPrincipalController(view);
		view.setVisible(true);
	}
}