package control;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CadastraTransacaoDAO;
import dao.CadastroDAO;
import dao.Conexao;
import model.Conta;

/**
 * Servlet implementation class ServletCadastroTransacao
 */
@WebServlet("/cadastroTransacao")
public class ServletCadastroTransacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastroTransacao() {
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate datatransacao = LocalDate.parse(request.getParameter("datatransacao"), formatter);
		String tipotransacao = request.getParameter("tipotransacao");
		float valortransacao = Float.parseFloat(request.getParameter("valortransacao"));
		int idconta = Integer.parseInt(request.getParameter("idconta"));
		
		
		// Recuperar os parametros
		Connection conexao = Conexao.getConexao();
		
		// Instanciar objeto CadastraTransacaoDAO
		CadastraTransacaoDAO c = new CadastraTransacaoDAO(conexao);
		
		
		boolean resultado = false;
		resultado = c.getCadastro(datatransacao, tipotransacao, valortransacao, idconta); 
		
		if (resultado) {
			
			RequestDispatcher rd = request.getRequestDispatcher("transacaoCadastrada.jsp");
			rd.forward(request, response);
		
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("SemExtrato.jsp");
			rd.forward(request, response);
		}
	}
}
