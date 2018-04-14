package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.Conexao;
import model.Cliente;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
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
		String cpfCliente = request.getParameter("cpfcliente");
		String senhaCliente = request.getParameter("senhacliente");

		// Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();

		// Instanciar objeto ClienteDAO
		ClienteDAO cd = new ClienteDAO(conexao);

		// Verificar se o usuario é valido
		if (cd.isCliente(cpfCliente, senhaCliente)) {
			// Obter cliente
			Cliente c = cd.getCliente(cpfCliente, senhaCliente);

			// Criar atributo novo
			request.setAttribute("cliente", c);

			// Repassar o request/respose para o JSP
			RequestDispatcher rd = request.getRequestDispatcher("loginSucesso.jsp");

			rd.forward(request, response);

		} else {
			// Repassar o request/respose para o JSP
			RequestDispatcher rd = request.getRequestDispatcher("loginFailed.html");

			rd.forward(request, response);

		}

	}

}
