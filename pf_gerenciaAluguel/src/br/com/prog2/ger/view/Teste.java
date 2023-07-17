package br.com.prog2.ger.view;
import java.util.List;

import br.com.prog2.ger.controller.ChaleController;
import br.com.prog2.ger.controller.HospedagemController;
import br.com.prog2.ger.model.Chale;
import br.com.prog2.ger.model.Hospedagem;

public class Teste {
	public static void main(String[] args) {
		Hospedagem hos = new Hospedagem();
		HospedagemController controller = new HospedagemController();
		hos.setCodChale(1);
		hos.setEstado("DF");
		hos.setDataInicio("22-02-2024");
		hos.setDataFim("05-03-2024");
		hos.setQtdPessoas(2);
		hos.setDesconto(0);
		hos.setValorFinal();
		System.out.println(controller.inserir(hos));
	}
}
