package br.com.prog2.ger.persistencia;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String user = "tfinal";/*Coloque o usuário criado para acesso ao banco*/
		String senha = "123456";/*Coloque a senha para acesso ao banco*/
		String url = "jdbc:postgresql://127.0.0.1:5449/tfinal";/*Coloque o
		//servidor onde está instalado o banco*/
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user,senha);
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		return con;
		}
	
	public static void close(Connection con){
		try{
			con.close();
		}catch(SQLException e){}
	}
	
	public static void listaColunas (String nomeTabela) {
		Connection con = ConnectionFactory.getConnection();
		try {
            // Nome da tabela desejada
            String tableName = nomeTabela;

            // Obter metadados do banco de dados
            DatabaseMetaData metaData = con.getMetaData();

            // Obter informações sobre as colunas da tabela
            ResultSet columns = metaData.getColumns(null, null, tableName, null);

            // Iterar sobre as colunas e exibir informações
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                int columnSize = columns.getInt("COLUMN_SIZE");

                System.out.println("Nome da coluna: " + columnName);
                System.out.println("Tipo da coluna: " + columnType);
                System.out.println("Tamanho da coluna: " + columnSize);
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectionFactory.close(con);
        }
    }
}
