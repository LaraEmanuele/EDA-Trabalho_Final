package br.com.prog2.ger.controller;

import java.util.List;
import br.com.prog2.ger.model.Chale;
import br.com.prog2.ger.persistencia.ChaleDAOImp;


public class ChaleController {
	public String inserir(Chale cha){
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.inserir(cha);
	}
		public String alterar(Chale cha) {
			ChaleDAOImp dao = new ChaleDAOImp();
		return dao.alterar(cha);
		}
		public String excluir(Chale cha){
			ChaleDAOImp dao = new ChaleDAOImp();
		return dao.excluir(cha);
		}
		public List<Chale> listarTodos(){
			ChaleDAOImp dao = new ChaleDAOImp();
		return dao.listarTodos();
		}
		public Chale pesquisarPorCodChale(int cod){
			ChaleDAOImp dao = new ChaleDAOImp();
		return dao.pesquisarPorCodChale(cod);
		}
}
