package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class CadastraTransacaoDAO {

	// Atributo
	private Connection conexao;

	// Metodo construtor
	public CadastraTransacaoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	// Metodo que Cadastra Transação para conta
	public boolean getCadastro(LocalDate datatransacao, String tipotransacao, float valortransacao,int idconta) {

		// Instanciar os objetos
		PreparedStatement ps = null;
		boolean resultado = false;

		System.out.println(datatransacao);
		System.out.println(tipotransacao);
		System.out.println(valortransacao);
		System.out.println(idconta);
		
		
		// Verificar se o cliente existe no BD
		try {

			// Preparar o SQL
			String sql = "INSERT INTO `banco`.`transacao` (`datatransacao`, `tipotransacao`, `valortransacao`, `idconta`) VALUES (?, ?, ?, ?);";
			ps = conexao.prepareStatement(sql);

			// Setar os parametros do SQL
			ps.setDate(1, java.sql.Date.valueOf(datatransacao));
			ps.setString(2, tipotransacao);
			ps.setFloat(3, valortransacao);
			ps.setInt(4, idconta);

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

