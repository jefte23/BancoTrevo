package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.Client;

import dao.CadastraContaDAO;
import dao.CadastraTransacaoDAO;
import dao.Conexao;
import model.Cliente;

/**
 * Servlet implementation class ServletAbrirConta
 */
@WebServlet("/cadastraConta")
public class ServletAbrirConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirConta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Recupera informações
		Cliente c = (Cliente) request.getSession().getAttribute(ServletLogin.CLIENTE_SESSION);
		String numeroconta = (String) request.getParameter("numeroconta");
		String agenciaconta = (String) request.getParameter("agenciaconta");
		String tipoconta = (String) request.getParameter("tipoconta");
		
		// Recuperar os parametros
		Connection conexao = Conexao.getConexao();
		
		// Instanciar objeto CadastraTransacaoDAO
		CadastraContaDAO cc = new CadastraContaDAO(conexao);
								
		boolean resultado = false;
		resultado = cc.getCadastro(c.getIdCliente(), numeroconta, agenciaconta, tipoconta); 

		if (resultado) {
			
			RequestDispatcher rd = request.getRequestDispatcher("transacaoCadastrada.jsp");
			rd.forward(request, response);
		
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("SemExtrato.jsp");
			rd.forward(request, response);
		}
		
	}

}
