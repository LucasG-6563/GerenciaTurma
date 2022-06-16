package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {

	public Connection con = null; // realiza a conex�o
	public PreparedStatement st = null; // executa as instru��es SQL
	public ResultSet rs = null; // Armazena as querys

	public final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // driver de conex�o ao banco
	public final String BANCO = "BD_PI";
	public final String URL = "jdbc:sqlserver://localhost:1433;databasename=" + BANCO;
	public final String LOGIN = "sa";
	public final String SENHA = "luscacodx1sa";

	/**
	 * Abre uma conex�o com o banco de dados a partir dos dados fornecidos acima
	 * 
	 * @return - true em caso de sucesso ou false caso contr�rio
	 */
	public boolean getConnection() {
		// carregar o driver
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou!!!");
			return true;

		} catch (ClassNotFoundException erro) {
			System.out.println("Driver n�o encontrado!!!!");
			return false;
		} catch (SQLException e) {
			System.out.println("Falha na conex�o :( " + e);
			return false;
		}
	}

	/**
	 * Encerra a conex�o com o banco de dados
	 */
	public void close() {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException erro) {}
		
		try {
			if (st != null)
				st.close();
		} catch (SQLException erro) {}
		
		try {
			if (con != null) {
				con.close();
				System.out.println("Desconectou!");
			}
		} catch (SQLException erro) {}
		

	}

}
