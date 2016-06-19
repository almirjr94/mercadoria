package br.com.valemobi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.valemobi.model.Mercadoria;
import br.com.valemobi.model.TipoNegocio;
import br.com.valemobi.service.MercadoriaService;

@WebServlet("/mercadoria.do")
public class SalvarMercadoriaController extends HttpServlet {

	private static final long serialVersionUID = -5203558672975731521L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cod = req.getParameter("cod");
		String nome = req.getParameter("txtNome");
		String tipo = req.getParameter("txtTipo");
		String quantidade = req.getParameter("txtQtd");
		String preco = req.getParameter("txtPreco");
		String negocio = req.getParameter("rNegocio");

		Long id = 0l;

		if (cod != null && !cod.trim().equals("") && !cod.equals("null")) {
			id = Long.valueOf(cod);
		}

		Mercadoria mercadoria = new Mercadoria(id, tipo, nome, Long.valueOf(quantidade), Double.valueOf(preco),
				TipoNegocio.valueOf(negocio));
		new MercadoriaService().salvar(mercadoria);
		
		resp.sendRedirect("listm.do");;

	}

}
