package br.com.valemobi.service;

import java.util.List;

import br.com.valemobi.dao.MercadoriaDAO;
import br.com.valemobi.model.Mercadoria;

public class MercadoriaService {

	public void salvar(Mercadoria mercadoria) {

		if (mercadoria.getCodigo() == 0 || mercadoria.getCodigo() == null) {
			new MercadoriaDAO().insert(mercadoria);
		} else {
			new MercadoriaDAO().update(mercadoria);
		}
	}

	public void excluir(Long codigo) {
		if (codigo == 0 || codigo == null) {
			throw new IllegalArgumentException("Informar o Código da Mercadoria");
		}
		new MercadoriaDAO().delete(codigo);
	}

	public List<Mercadoria> buscarTodas(){
		
		return new MercadoriaDAO().selectAll();
	}
	
	public Mercadoria buscarPorCodigo(Long codigo){
		if (codigo == 0 || codigo == null) {
			throw new IllegalArgumentException("Informar o Código da Mercadoria");
		}
		return new MercadoriaDAO().selectByCod(codigo);
	}
}
