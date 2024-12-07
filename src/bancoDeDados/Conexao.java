package bancoDeDados;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
	private static final String URL = "jdbc:mysql://localhost:3306/GerenciamentoEstudantil";
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
