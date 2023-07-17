package br.com.prog2.ger.controller;
import java.util.List;
import br.com.prog2.ger.model.Cliente;
import br.com.prog2.ger.persistencia.ClienteDAOImp;


public class ClienteController {
	public String inserir(Cliente cli){
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.inserir(cli);
	}
	public String alterar(Cliente cli) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.alterar(cli);
	}
	public String excluir(Cliente cli){
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.excluir(cli);
	}
	public List<Cliente> listarTodos(){
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.listarTodos();
	}
	public Cliente pesquisarPorRg(String rg){
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.pesquisarPorRg(rg);
	}
}
