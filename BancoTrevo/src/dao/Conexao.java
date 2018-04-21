package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	// Metodo para retornar uma conexao ao BD
	public static Connection getConexao() {

		// Criando objeto de conexao
		Connection conexao = null;

		// Conectar no banco de dados
		try {

			// Referencia os drives do JDBC
			Class.forName("com.mysql.jdbc.Driver");

			// cria String de conexao
			String url = "jdbc:mysql://localhost/banco";
			String username = "root";
			String password = "root";

			// Realizar conexão com banco de dados
			conexao = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			// Mostra o erro
			e.printStackTrace();
		}

		return conexao;
	}

}
