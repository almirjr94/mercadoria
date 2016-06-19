package br.com.valemobi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.valemobi.service.MercadoriaService;

@WebServlet("/exmerc.do")
public class ExcluirMercadoriaController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String cod = req.getParameter("cod");
	
	Long id = 0l;
	if(cod != null && !cod.trim().equals("") && !cod.equals("null")){
		id = Long.valueOf(cod);
	}
	new MercadoriaService().excluir(id);
	

	resp.sendRedirect("listm.do");
	
		
	}
	
}
