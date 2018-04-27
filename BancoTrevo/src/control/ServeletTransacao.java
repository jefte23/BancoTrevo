package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.Conexao;
import dao.ContaDAO;
import dao.TransacaoDAO;
import model.Cliente;
import model.Conta;
import model.Transacao;

/**
 * Servlet implementation class ServeletTransacao
 */
@WebServlet("/transacao")
public class ServeletTransacao extends HttpServlet {
	public static final String CONTA_SESSION = "contaCliente";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletTransacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recuperar os parametros
		int idconta = Integer.parseInt(request.getParameter("idconta"));

		Cliente c = (Cliente) request.getSession().getAttribute(ServletLogin.CLIENTE_SESSION);
		
		// Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();

		// Instanciar objeto ClienteDAO
		ContaDAO cd = new ContaDAO(conexao);

		// Obter contas
		ArrayList<Conta> conta = cd.getConta(c.getIdCliente());
		
		TransacaoDAO td = new TransacaoDAO(conexao);

		// Obtet transações da conta solicitada
		ArrayList<Transacao> transacoes = td.getConta(idconta);

		// Variavel para calcular valor total da conta corrente
		float extratoConta = 0;

		// Calcula extrato bancario
		for (int i = 0; i < transacoes.size(); i++) {
			if (transacoes.get(i).getTipoTransacao().equals("C")
					|| transacoes.get(i).getTipoTransacao().equals("c")) {
				extratoConta += transacoes.get(i).getValorTransacao();
			} else {
				extratoConta -= transacoes.get(i).getValorTransacao();
				}
			}

			// Criar atributo novo
			request.setAttribute("conta", conta);
			request.setAttribute("transacoes", transacoes);
			request.setAttribute("extratoConta", extratoConta);

			// Repassar o request/respose para o JSP
			RequestDispatcher rd = request.getRequestDispatcher("TransacoesConta.jsp");

			rd.forward(request, response);

	}
}
