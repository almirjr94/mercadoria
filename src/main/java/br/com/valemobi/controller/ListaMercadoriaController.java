package br.com.valemobi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.valemobi.model.Mercadoria;
import br.com.valemobi.service.MercadoriaService;

@WebServlet("/listm.do")
public class ListaMercadoriaController extends HttpServlet{

	private static final long serialVersionUID = 1727442081968176134L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Mercadoria> mercadorias = new MercadoriaService().buscarTodas();
		
		req.setAttribute("lista", mercadorias);
		req.getRequestDispatcher("WEB-INF/listaMercadoria.jsp").forward(req, resp);;
		
		
	}

}
