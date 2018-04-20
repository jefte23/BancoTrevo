package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CadastroDAO;
import dao.ClienteDAO;
import dao.Conexao;
import model.Cliente;

/**
 * Servlet implementation class ServletCadastro
 */
@WebServlet("/cadastro")
public class ServletCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCadastro() {
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
		String cpfcliente = request.getParameter("cpfcliente");
		String nomecliente = request.getParameter("nomecliente");
		String senhacliente = request.getParameter("senhacliente");

		// Recuperar os parametros
		Connection conexao = Conexao.getConexao();

		// Instanciar objeto ClienteDAO
		CadastroDAO c = new CadastroDAO(conexao);

		// Verificar se o usuario é existe
		if (c.isCliente(cpfcliente, senhacliente)) {

			request.getRequestDispatcher("loginFailed.html");

		} else {

			c.getCadastro(cpfcliente, nomecliente, senhacliente);

			// Instanciar objeto ClienteDAO
			ClienteDAO cd = new ClienteDAO(conexao);

			// Obter cliente
			Cliente d = cd.getCliente(cpfcliente, senhacliente);

			// Criar atributo novo
			request.setAttribute("cliente", d);

			// Repassar o request/respose para o JSP
			RequestDispatcher rd = request.getRequestDispatcher("loginSucesso.jsp");

			rd.forward(request, response);

		}

	}

}
