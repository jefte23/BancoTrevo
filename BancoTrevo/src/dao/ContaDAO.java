package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Conta;

public class ContaDAO {

	private Connection conexao;

	public ContaDAO(Connection conexao) {
		this.conexao = conexao;
	}

	// Metodo que verifica se existe conta para este cliente
	public boolean isContaCliente(int idcliente) {

		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean resultado = false;

		// Verifica se conta Existe para esté cliente
		try {
			// Prepara o SQL
			String sql = "SELECT idconta, numeroconta, agenciaconta, tipoconta FROM banco.conta WHERE idcliente = ?";
			ps = conexao.prepareStatement(sql);

			// Seta o parametro do SQL
			ps.setInt(1, idcliente);

			// Execulta o SQL
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

	// Metodo que retorna contas dos cliente
	public ArrayList<Conta> getConta(int idcliente) {

		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Conta> contas = new ArrayList<Conta>();

		// Verifica se conta Existe para esté cliente
		try {

			// Prepara o SQL
			String sql = "SELECT idcliente, idconta, numeroconta, agenciaconta, tipoconta FROM banco.conta WHERE idcliente = ?";
			ps = conexao.prepareStatement(sql);

			// Seta o parametro do SQL
			ps.setInt(1, idcliente);

			// Execulta o SQL
			rs = ps.executeQuery();

			while (rs.next()) {
				Conta c = new Conta(rs.getInt("idcliente"), rs.getInt("idconta"), rs.getString("numeroconta"),
						rs.getString("agenciaConta"), rs.getString("tipoConta"));

				contas.add(c);
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contas;
	}
	// Metodo que retorna Conta Selecionada pelo cliente
	public Conta getUnicaConta(int idconta) {

		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conta contas = null;

		// Verifica se conta Existe para esté cliente
		try {

			// Prepara o SQL
			String sql = "SELECT idcliente, idconta, numeroconta, agenciaconta, tipoconta FROM banco.conta WHERE idconta = ?";
			ps = conexao.prepareStatement(sql);

			// Seta o parametro do SQL
			ps.setInt(1, idconta);

			// Execulta o SQL
			rs = ps.executeQuery();

			while (rs.next()) {
				contas = new Conta(rs.getInt("idcliente"), rs.getInt("idconta"), rs.getString("numeroconta"),
						rs.getString("agenciaConta"), rs.getString("tipoConta"));
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contas;
	}	
	
	
}
