package com.up.clinica.servico;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.clinica.dal.AnimalDAO;

public class AbstractService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private AnimalDAO animalDAO = new AnimalDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("application/json;charset=UTF-8");
			ServletOutputStream out = response.getOutputStream();
						
			JsonConverter converter = new JsonConverter();
			String output = converter.convertToJson(animalDAO.listar(),"Animais");
			out.print(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
