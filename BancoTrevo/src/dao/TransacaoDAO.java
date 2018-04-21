package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Transacao;

public class TransacaoDAO {

	// Atributo
	private Connection conexao;

	// Metodo construtor
	public TransacaoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	// Metodo que verifica se o cliente existe com cpf e senha corretos
	public boolean isTransacao(int idconta) {

		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean resultado = false;

		// Verificar se o cliente existe no BD
		try {
			// Preparar o SQL
			String sql = "SELECT idconta FROM banco.transacao WHERE idconta=?";
			ps = conexao.prepareStatement(sql);

			// Setar os parametros do SQL
			ps.setInt(1, idconta);

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

	// Metodo que retorna Transações
	public ArrayList<Transacao> getConta(int idconta) {

		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

		// Verifica se conta Existe para esté cliente
		try {
			// Formato data e Hora
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// Prepara o SQL
			String sql = "SELECT * FROM banco.transacao WHERE idconta = ?";
			ps = conexao.prepareStatement(sql);

			// Seta o parametro do SQL
			ps.setInt(1, idconta);

			// Execulta o SQL
			rs = ps.executeQuery();

			while (rs.next()) {
				Transacao t = new Transacao(rs.getInt("idtransacao"), rs.getInt("idconta"),
						LocalDate.parse(rs.getString("datatransacao"), formatter), rs.getString("tipotransacao"),
						rs.getFloat("valortransacao"));

				transacoes.add(t);
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transacoes;
	}

}
