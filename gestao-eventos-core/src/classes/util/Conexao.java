package classes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	// Teste
	
	public static Connection getConnection() 
			throws ClassNotFoundException, 
		SQLException{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/gestaoeventos";
		String user = "user";
		String password = "pass";
		
		try {
			Class.forName( driver );
			Connection conn = 
					DriverManager.getConnection( url, user, password);

			return conn;
		} catch (SQLException e) {
			System.out.println("Erro na conexao\n"+ e);
			
		}
		
		return null;	

	}

}
