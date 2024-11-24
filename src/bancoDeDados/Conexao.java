package bancoDeDados;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class Conexao {
	private static final String URL = "";
	private static final String USER = "root";
	private static final String PASSWORD = "admin123";
	private static Connection conexao;
	
	public Conexao() {};
	
	public static Connection getConnection() {
		if(conexao != null) {			
			try {
				conexao = DriverManager.getConnection(URL, USER, PASSWORD);
			}catch(SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Erro ao contatar o Banco de dados", e);
			}
		}
		return conexao;
	}
	
	 public static void closeConnection() {
	        if (conexao != null) {
	            try {
	                conexao.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }	
}
