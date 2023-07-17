package br.com.prog2.ger.persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.ger.model.Cliente;

public class ClienteDAOImp implements ClienteDAO{
	
	private Cliente ultimoCodCliente (Cliente cli) {
	    Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
		
		try {
			String sql = "SELECT MAX (CODCLIENTE) FROM Cliente";
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			if(rs.next()){
				cli.setCodCliente(rs.getInt(1)+1);
				return cli;
			}else{
				return null;
			}
		}catch(SQLException e){
			return null;
		}finally {
			try {
	            if (rs != null) rs.close();
	            if (pst != null) pst.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
	}
	
	@Override
	public String inserir(Cliente cli) {
		String sql = "insert into Cliente ("
					 + "codCliente,"
					 + "nomeCliente, "
					 + "rgCliente, "
					 + "enderecoCliente, "
					 + "bairroCliente, "
					 + "cidadeCliente, "
					 + "estadoCliente, "
					 + "cepCliente, "
					 + "nascimentoCliente)"
					 +" values (?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ultimoCodCliente (cli);
			pst.setInt(1, cli.getCodCliente ());
			pst.setString(2, cli.getNomeCliente());
			pst.setString(3, cli.getRgCliente());
			pst.setString(4, cli.getEnderecoCliente());
			pst.setString(5, cli.getBairroCliente());
			pst.setString(6, cli.getCidadeCliente());
			pst.setString(7, cli.getEstadoCliente());
			pst.setString(8, cli.getCEPCliente());
			pst.setDate(9, cli.getNascimentoCliente());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Inserido com sucesso.";
			}else{
				return "Erro ao inserir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	
	@Override
	public String alterar(Cliente cli) {
			String sql = "update cliente set "
							 + "nomeCliente = ?, "
							 + "rgCliente = ?, "
							 + "enderecoCliente = ?, "
							 + "bairroCliente = ?, "
							 + "cidadeCliente = ?, "
							 + "estadoCliente = ?, "
							 + "cepCliente = ?, "
							 + "nascimentoCliente = ? "
							 + "where codCliente = ?";
			Connection con = ConnectionFactory.getConnection();
			try{
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, cli.getNomeCliente());
				pst.setString(2, cli.getRgCliente());
				pst.setString(3, cli.getEnderecoCliente());
				pst.setString(4, cli.getBairroCliente());
				pst.setString(5, cli.getCidadeCliente());
				pst.setString(6, cli.getEstadoCliente());
				pst.setString(7, cli.getCEPCliente());
				pst.setDate(8, cli.getNascimentoCliente());
				pst.setInt(9, cli.getCodCliente());
				int res = pst.executeUpdate();
				if(res > 0){
					return "Alterado com sucesso.";
				}else{
					return "Erro ao alterar.";
				}
			}catch(SQLException e){
				return e.getMessage();
			}finally {
				ConnectionFactory.close(con);
			}
	}
	
	
	@Override
	public String excluir(Cliente cli) {
		String sql = "delete from cliente where rgCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cli.getNomeCliente());
			int res = pst.executeUpdate();
			
			if(res > 0){
				return "Excluído com sucesso.";
			}else{
				return "Erro ao excluir.";
			}
			
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
		
	}
	
	
	@Override
	public List<Cliente> listarTodos() {
			String sql = "select * from cliente";
			Connection con = ConnectionFactory.getConnection();
			List <Cliente> lista = new ArrayList<>();
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Cliente ep = new Cliente();
						ep.setNomeCliente(rs.getString(1));
						ep.setRgCliente(rs.getString(2));
						ep.setEnderecoCliente(rs.getString(3));
						ep.setBairroCliente(rs.getString(4));
						ep.setCidadeCliente(rs.getString(5));
						ep.setEstadoCliente(rs.getString(6));
						ep.setCEPCliente(rs.getString(7));
						ep.setNascimentoCliente(rs.getString(8));
						ep.setCodCliente(rs.getInt(9));
						lista.add(ep);
					}
					return lista;
				} else {
					System.out.println("Lista de clientes vazia");
					return null;
				}
			} catch (SQLException e) {
			return null;
			} finally {
			ConnectionFactory.close(con);
			}
	}
	@Override
	public Cliente pesquisarPorRg(String rg) {
		String sql = "select * from cliente where rgCliente=?;";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, rg);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente ep = new Cliente();
				ep.setNomeCliente(rs.getString(1));
				ep.setRgCliente(rs.getString(2));
				ep.setEnderecoCliente(rs.getString(3));
				ep.setBairroCliente(rs.getString(4));
				ep.setCidadeCliente(rs.getString(5));
				ep.setEstadoCliente(rs.getString(6));
				ep.setCEPCliente(rs.getString(7));
				ep.setNascimentoCliente(rs.getString(8));
				ep.setCodCliente(rs.getInt(9));
				return ep;
			} else {
			return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
}
