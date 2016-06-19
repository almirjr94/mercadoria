package br.com.valemobi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.valemobi.model.Mercadoria;
import br.com.valemobi.service.MercadoriaService;

@WebServlet("/editmerc.do")
public class EditarMercadoriaController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = 0l;
		String cod = req.getParameter("cod");
		
		if(cod != null && !cod.trim().equals("") && !cod.equals("null")){
			id = Long.valueOf(cod);
		}
		
	Mercadoria mercadoria = new MercadoriaService().buscarPorCodigo(id);
	
	req.setAttribute("mercadoria", mercadoria);
	req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
	
		
	}

	
}
