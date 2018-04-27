<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sun.xml.internal.ws.api.ha.StickyFeature"%>
<%@page import="java.util.*"%>
<%@page import="dao.*"%>
<%@page import="control.*"%>
<%@page import="model.*"%>

<% Cliente c = (Cliente) request.getSession().getAttribute(ServletLogin.CLIENTE_SESSION); %>
<% Conta ct = (Conta) request.getSession().getAttribute(ServeletTransacao.CONTA_SESSION); %>

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
            <li> <a href="#">empresa</a> </li>
            <li> <a  href="contas">Conta Corrente</a> </li>
			 
            <li class="dropdown"> 
             	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user glyphicon"></span>  
                </a> 
             
              <ul class="dropdown-menu">
                <li> <a href="#"><%= c.getNomeCliente() %></a> </li>
                <li> <a href="#">Editar perfil</a> </li>
                <li> <a href="#" onclick="confirmaSaida()" >Sair</a> </li>
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
        	<h3> Sr, <%=c.getNomeCliente() %></h3>
            </div>

            <div class="col-xs-6  marcador">
           	 	<h3 align="center"></h3>
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
	          
	        	<h3 align="center">Transação Concluida com sucesso</h3>  
	          
        </div> 
    </div>
     	<div class="row">
	       	<div class="col-xs-3  marcador">
	              <h1 align="center"></h1>
	        </div>
		</div>     
<!-- Fim row 2 -->

    
<br><br><br><br><br><br><br>
    
<!-- Rodape -->
    
    <footer id="rodape">
      <div class="container">
        <div class="row">
          
          <div class="col-md-2">
            <span class="img-logo">Trevo</span>
          </div>

          <div class="col-md-2">
            <h4>company</h4>
            <ul class="nav">
            </ul>
          </div>

          <div class="col-md-2">
            <h4>comunidades</h4>
            <ul class="nav">
            </ul>
          </div>

          <div class="col-md-2">
            <h4>links uteis</h4>
            <ul class="nav">
            </ul>
          </div>

          <div class="col-md-4">
            <ul class="nav">
              <li class="item-rede-social"><a href=""><img src="imagens/facebook.png"></a></li>
              <li class="item-rede-social"><a href=""><img src="imagens/twitter.png"></a></li>
              <li class="item-rede-social"><a href=""><img src="imagens/instagram.png"></a></li>
            </ul>
          </div>

        </div><!-- /row -->
      </div>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>