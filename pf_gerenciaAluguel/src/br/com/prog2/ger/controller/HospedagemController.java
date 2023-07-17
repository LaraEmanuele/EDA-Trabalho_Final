package br.com.prog2.ger.controller;

import java.util.List;

import br.com.prog2.ger.model.Hospedagem;
import br.com.prog2.ger.persistencia.HospedagemDAOImp;

public class HospedagemController {
	public String inserir(Hospedagem hos){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.inserir(hos);
	}
	public String alterar(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.alterar(hos);
	}
	public String excluir(Hospedagem hos){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.excluir(hos);
	}
	public List<Hospedagem> listarTodos(){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.listarTodos();
	}
	public Hospedagem pesquisarPorCodHospedagem(int cod){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodHospedagem(cod);
	}
}
