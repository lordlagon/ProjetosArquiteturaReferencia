package com.up.clinica.servico;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.clinica.dal.EspecieDAO;


@WebServlet(name = "GetEspecies", urlPatterns = { "/GetEspecies" })
public class EspecieService extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EspecieDAO especieDAO = new EspecieDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("application/json;charset=UTF-8");
			ServletOutputStream out = response.getOutputStream();
						
			JsonConverter converter = new JsonConverter();
			String output = converter.convertToJson(especieDAO.listar(),"Especies");
			out.print(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	

