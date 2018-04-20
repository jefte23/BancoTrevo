package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDAO {

	// Atributo
	private Connection conexao;

	// Metodo construtor
	public CadastroDAO(Connection conexao) {
		this.conexao = conexao;
	}

	// Metodo que verifica se o cliente existe com cpf e senha corretos
	public boolean isCliente(String cpfCliente, String senhaCliente) {

		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean resultado = false;

		// Verificar se o cliente existe no BD
		try {

			// Preparar o SQL
			String sql = "SELECT idcliente FROM banco.cliente WHERE cpfcliente=? and senhacliente=?";
			ps = conexao.prepareStatement(sql);

			// Setar os parametros do SQL
			ps.setString(1, cpfCliente);
			ps.setString(2, senhaCliente);

			// Executar o SQL
			rs = ps.executeQuery();

			// Verifica se o rs retornou resultado
			resultado = rs.first();

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	// Metodo que Cadastra um cliente
	public boolean getCadastro(String cpfCliente, String nomeCliente, String senhaCliente) {

		// Instanciar os objetos
		PreparedStatement ps = null;
		boolean resultado = false;

		// Verificar se o cliente existe no BD
		try {

			// Preparar o SQL
			String sql = "INSERT INTO `banco`.`cliente` (`cpfcliente`, `nomecliente`, `senhacliente`) VALUES (?, ?, ?);";
			ps = conexao.prepareStatement(sql);

			// Setar os parametros do SQL
			ps.setString(1, cpfCliente);
			ps.setString(2, nomeCliente);
			ps.setString(3, senhaCliente);

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
