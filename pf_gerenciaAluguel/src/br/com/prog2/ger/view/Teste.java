package br.com.prog2.ger.view;
import java.util.List;

import br.com.prog2.ger.controller.ChaleController;
import br.com.prog2.ger.model.Chale;

public class Teste {
	public static void main(String[] args) {
		ChaleController controller = new ChaleController();
		Chale cha = new Chale();
		cha = controller.pesquisarPorCodChale(2);
		if (cha != null) {
			System.out.println("Codigo Chale: "+cha.getCodChale());
			System.out.println("Localizacao: "+cha.getLocalizacao());
			System.out.println("Capacidade: "+cha.getCapacidade());
			System.out.println("Valor alta estacao: "+cha.getValorAltaEstacao());
			System.out.println("Valor baixa estacao: "+cha.getValorBaixaEstacao());
			System.out.println("-------------------------------------------------");
		}
	}
}
