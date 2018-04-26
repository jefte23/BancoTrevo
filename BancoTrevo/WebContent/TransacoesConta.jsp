<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sun.xml.internal.ws.api.ha.StickyFeature"%>
<%@page import="java.util.*"%>
<%@page import="java.time.LocalDate"%>
<%@page import="dao.*"%>
<%@page import="control.*"%>
<%@page import="model.Cliente"%>
<%@page import="model.Conta"%>
<%@page import="model.Transacao"%>


<% Cliente c = (Cliente) request.getSession().getAttribute(ServletLogin.CLIENTE_SESSION); %>

<!doctype html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Home</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="estilo.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
        
        
    <!-- Confirmação de saida : https://www.devmedia.com.br/forum/janela-de-confirmacao-com-javascript/568152 -->
    <script>
		function confirmaSaida() {
		   if (confirm("Tem certeza que deseja Sair do perfil?")) {
		      location.href="http://localhost:8080/BancoTrevo/index.html";
		   }
		}
	</script>
    
    
  </head>
  <body>
  
    <!-- Barra navegação -->
    <nav class="navbar navbar-default navbar-transparente ">
      <div class="container">
        
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" 
                  data-toggle="collapse" data-target="#barra-navegacao">
            <span class="sr-only">Alternar Menu</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
         <a  href="loginSucesso.jsp" class="navbar-brand">
          	<span class="img-logo"></span>
          </a>
        </div>

        <div class="collapse navbar-collapse" id="barra-navegacao">

          <ul class="nav navbar-nav navbar-right">
            <li> </li>
            <li> <a href="#">empresa</a> </li>
            <li> <a href="#">Aplicações</a> </li>
 
            <li class="dropdown"> 
             	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user glyphicon"></span>  
                </a> 
             
              <ul class="dropdown-menu">
                <li> <a href="loginSucesso.jsp"><%=c.getNomeCliente() %></a></li>
                <li> <a href="#">Editar perfil</a> </li>
                <li> <a href="#" onclick="confirmaSaida()">Sair</a> </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>



	<!-- ------------------ Inicio da Pagina ------------------ -->
   <section id="servicos">
    <div class="container">
		<div class="row">
            <div class="col-xs-6  marcador">
        		<h3 align="center">Bem vindo, <%=c.getNomeCliente() %></h3>
            </div>

            <div class="col-xs-6  marcador">
            <h3 align="center">As contas correntes em seu nome</h3>
            
            <table class="table table-bordered table-hover">
			      <thead align="center">
			        <tr>
			          <th>Conta</th>
			          <th>Agencia</th>
			        </tr>
			      </thead>
		    <%
				List<Conta> contas = (List<Conta>) request.getAttribute("conta");
				for (int i = 0; i< contas.size();i++){
			%>

			 	<tbody>
	             	<tr >
						<td align="center">
							<a href="transacao?idconta=<%=contas.get(i).getIdConta()%>"><%=contas.get(i).getNumeroConta() %></a>
						</td>
						<td align="center"> 
							<a href="transacao?idconta=<%=contas.get(i).getIdConta()%>"><%=contas.get(i).getNumeroConta() %></a>
						</td>


					</tr>
				</tbody>
				<%
					}
				%>
				</table>

            </div>
        </div>
	</div>
</section>
   
        
       <!-- Fim row 1 -->
        
 	<div class="row">
       	<div class="col-xs-3  marcador">
        	<h1 align="center"></h1>
        </div>
        <div class="col-xs-6  marcador">
        	<h1 align="center">Transações Bancarias</h1>
        	<%float extrato = (float) request.getAttribute("extratoConta"); %>
        	
        	<br><br>
        	<h3>Valor Disponivel: <Span></Span><%=extrato %>	</h3>
            	
            	<table class="table table-bordered table-hover">
			      <thead align="center">
			        <tr>
			          <th>Data Transação</th>
			          <th>Tipo Transação</th>
			          <th>Valor Transação</th>
			        </tr>
			      </thead>        	
			      
			      		    <%
				List<Transacao> transacaos = (List<Transacao>) request.getAttribute("transacoes");
				for (int i = 0; i< transacaos.size();i++){
			%>

			 	<tbody>
	             	<tr >
						<td align="center"> <%=transacaos.get(i).getDataTransacao() %> </td>
						<td align="center"> <%=transacaos.get(i).getTipoTransacao() %> </td>
						<td align="center"> <%=transacaos.get(i).getValorTransacao() %> </td>
					</tr>
				</tbody>
				<%
					}
				%>
				</table>
        	

        	
        </div> <!-- Fim row 2 -->
            
        <div class="col-xs-3  marcador">
        	<h1 align="center"></h1>
        </div>
     </div>
    
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
