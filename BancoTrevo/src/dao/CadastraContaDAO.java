package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastraContaDAO {
	
	// Atributo
	private Connection conexao;

	// Metodo construtor
	public CadastraContaDAO(Connection conexao) {
		this.conexao = conexao;
	}

	// Metodo que Cadastra Conta
	public boolean getCadastro(int idcliente, String numeroconta, String agenciaconta, String tipoconta) {
		
		// Instanciar os objetos
		PreparedStatement ps = null;
		boolean resultado = false;
		
		System.out.println(idcliente);
		System.out.println(numeroconta);
		System.out.println(agenciaconta);
		System.out.println(tipoconta);
		
		try {

			// Preparar o SQL
			String sql = "INSERT INTO `banco`.`conta` (`idcliente`, `numeroconta`, `agenciaconta`, `tipoconta`) VALUES (?, ?, ?, ?);";
			ps = conexao.prepareStatement(sql);

			// Setar os parametros do SQL
			ps.setInt(1, idcliente);
			ps.setString(2, numeroconta);
			ps.setString(3, agenciaconta);
			ps.setString(4, tipoconta);

			// Executar o SQL
			ps.executeUpdate();

			resultado = true;

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;

	}
}
	