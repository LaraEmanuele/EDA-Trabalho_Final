package br.com.prog2.ger.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.ger.model.Chale;

public class ChaleDAOImp implements ChaleDAO{
	
	private Chale ultimoCodChale (Chale cha) {
	    Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
		
		try {
			String sql = "SELECT MAX (CODCHALE) FROM CHALE";
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			if(rs.next()){
				cha.setCodChale(rs.getInt(1)+1);
				return cha;
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
	public String inserir(Chale cha) {
		String sql = "insert into Chale ("
				 + "codChale,"
				 + "localizacao, "
				 + "capacidade, "
				 + "valorAltaEstacao, "
				 + "valorBaixaEstacao) "
				 +" values (?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ultimoCodChale (cha);
			pst.setInt(1, cha.getCodChale ());
			pst.setString(2, cha.getLocalizacao());
			pst.setInt(3, cha.getCapacidade());
			pst.setBigDecimal(4, cha.getValorAltaEstacao());
			pst.setBigDecimal(5, cha.getValorBaixaEstacao());
			
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
	public String alterar(Chale cha){
		String sql = "update chale set localizacao=?, capacidade = ?, valorAltaEstacao=?,valorBaixaEstacao=?" + 
				"where codchale=?";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(5, cha.getCodChale ());
			pst.setString(1, cha.getLocalizacao());
			pst.setInt(2, cha.getCapacidade());
			pst.setBigDecimal(3, cha.getValorAltaEstacao());
			pst.setBigDecimal(4, cha.getValorBaixaEstacao());
			
			sql = "SELECT * FROM chale ORDER BY codchale";
			
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
	public String excluir(Chale cha){
		String sql = "delete from chale where codchale=?";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cha.getCodChale());
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
	public List<Chale> listarTodos(){
		String sql = "select * from chale";
		Connection con = ConnectionFactory.getConnection();
		List<Chale> lista = new ArrayList<>();
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Chale cha = new Chale();
				cha.setCodChale(rs.getInt(1));
				cha.setLocalizacao(rs.getString(2));
				cha.setCapacidade(rs.getInt(3));
				cha.setValorAltaEstacao(rs.getBigDecimal(4));
				cha.setValorBaixaEstacao(rs.getBigDecimal(4));
				lista.add(cha);
			}
			return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}


	}
	@Override
	public Chale pesquisarPorCodChale(int cod){
		String sql = "select * from chale where codchale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cod);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Chale cha = new Chale();
				cha.setCodChale(rs.getInt(1));
				cha.setLocalizacao(rs.getString(2));
				cha.setCapacidade(rs.getInt(3));
				cha.setValorAltaEstacao(rs.getBigDecimal(4));
				cha.setValorBaixaEstacao(rs.getBigDecimal(5));
				return cha;
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
