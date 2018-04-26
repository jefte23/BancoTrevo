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
import model.Cliente;
import model.Conta;

/**
 * Servlet implementation class ServletContas
 */
@WebServlet("/contas")
public class ServletContas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletContas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();

		Cliente c = (Cliente) request.getSession().getAttribute(ServletLogin.CLIENTE_SESSION);
		

		// Instanciar objeto ContaDAO
		ContaDAO cc = new ContaDAO(conexao);

		// Obter cliente
		
		// Recuperar os parametros
		int idcliente = c.getIdCliente();

		// Obter conta
		ArrayList<Conta> contas = cc.getConta(idcliente);

		// Criar atributo novo
		request.setAttribute("conta", contas);

		// rd.forward(request, response);

		// Repassar o request/respose para o JSP
		RequestDispatcher rd = request.getRequestDispatcher("dadosCliente.jsp");

		rd.forward(request, response);


	}
}
