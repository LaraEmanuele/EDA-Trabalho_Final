package br.com.prog2.ger.persistencia;

import java.util.List;

import br.com.prog2.ger.model.Hospedagem;

public interface HospedagemDAO {
		
		public String inserir(Hospedagem hos);
		public String alterar(Hospedagem hos);
		public String excluir(Hospedagem hos);
		public List<Hospedagem> listarTodos();
		public Hospedagem pesquisarPorCodHospedagem(int cod);


}
