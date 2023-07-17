package br.com.prog2.ger.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import br.com.prog2.ger.model.Hospedagem;

public class HospedagemDAOImp implements HospedagemDAO{
	private Hospedagem ultimoCodChale (Hospedagem hos) {
	    Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
		
		try {
			String sql = "SELECT MAX (CODHOSPEDAGEM) FROM HOSPEDAGEM";
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			if(rs.next()){
				hos.setCodHospedagem(rs.getInt(1)+1);
				return hos;
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
	public String inserir(Hospedagem hos) {
		String sql = "insert into Chale ("
				 + "codHospedagem, "
				 + "codChale, "
				 + "estado, "
				 + "dataInicio, "
				 + "dataFim, "
				 + "qtdPessoas, "
				 + "desconto, "
				 + "valorFinal) "
				 +" values (?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ultimoCodChale (hos);
			pst.setInt(1, hos.getCodHospedagem ());
			pst.setInt(2, hos.getCodChale ());
			pst.setString(3, hos.getEstado());
			pst.setDate(4, hos.getDataInicio());
			pst.setDate(5, hos.getDataFim());
			pst.setInt(6, hos.getQtdPessoas());
			pst.setDouble(7, hos.getDesconto());
			pst.setBigDecimal(8, hos.getValorFinal());
			
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
	public String alterar(Hospedagem hos) {
		return null;
	}

	@Override
	public String excluir(Hospedagem hos) {
		return null;
	}

	@Override
	public List<Hospedagem> listarTodos() {
		return null;
	}

	@Override
	public Hospedagem pesquisarPorCodHospedagem(int cod) {
		return null;
	}

}
