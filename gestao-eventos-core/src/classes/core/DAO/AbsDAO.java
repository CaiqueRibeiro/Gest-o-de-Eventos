package classes.core.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import classes.core.IDAO;
import classes.util.Conexao;


public abstract class AbsDAO implements IDAO{

	protected static Connection conexao;
	
	
		protected void conectar() {
			try {
				if(conexao == null || conexao.isClosed()) {
					conexao = Conexao.getConnection();
				}
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
	}
		
		public void fecharConexao() {
			
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
}
