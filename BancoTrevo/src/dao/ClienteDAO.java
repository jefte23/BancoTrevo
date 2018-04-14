package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class ClienteDAO {

	// Atributo
	private Connection conexao;

	// Metodo construtor
	public ClienteDAO(Connection conexao) {
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

	// Metodo que retorna 1 cliente
	public Cliente getCliente(String cpfCliente, String senhaCliente) {

		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente resultado = null;

		// Verificar se o cliente existe no BD
		try {

			// Preparar o SQL
			String sql = "SELECT idcliente, cpfcliente, nomecliente, senhacliente FROM banco.cliente WHERE cpfcliente=? and senhacliente=?";
			ps = conexao.prepareStatement(sql);

			// Setar os parametros do SQL
			ps.setString(1, cpfCliente);
			ps.setString(2, senhaCliente);

			// Executar o SQL
			rs = ps.executeQuery();

			// Criar cliente com base no rs
			rs.first();

			resultado = new Cliente(rs.getInt("idcliente"), rs.getString("cpfcliente"), rs.getString("nomecliente"),
					rs.getString("senhacliente"));

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;

	}

}
