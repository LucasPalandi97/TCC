<%-- 
    Document   : ChamadoCriadoSucesso
    Created on : 20/10/2019, 19:30:10
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Chamado criado</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/skin.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="./script/index.js"></script>
</head>

<body id="wrapper">

    <header>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="row">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
                        <a class="navbar-brand" href="#">
                            <h1>HELPER</h1><span>GERENCIADOR DE CHAMADOS DE T.I.</span></a>
							<div class="boasvindas">
							<label>Olá, </label>
							</div>
                    </div>
                    <div id="navbar" class="collapse navbar-collapse navbar-right">
                        <ul class="nav navbar-nav">
                            
                            <li><a href="home.jsp">Início</a></li>
                            <li><a href="requisicao.jsp">Requisição</a></li>
                            <li><a href="incidentes.jsp">Incidentes</a></li>                   
                            <li><a href="login.jsp">Sair</a></li>
                        </ul>
                    </div>
                <!--/.nav-collapse -->
            </div>
        </nav>
        <!--/.nav-ends -->
    </header>

    <section id="faq">
        <div class="titlebar">
            <div class="container">
                <div class="row">
                 


                </div>

                </div>

            </div>
    </section>

    <div id="panel">
        <div id="panel-admin">
            <div class="panel-admin-box">
                <div id="tootlbar_colors">
                    <button class="color" style="background-color:#1abac8;" onclick="mytheme(0)"></button>
                    <button class="color" style="background-color:#ff8a00;" onclick="mytheme(1)"> </button>
                    <button class="color" style="background-color:#b4de50;" onclick="mytheme(2)"> </button>
                    <button class="color" style="background-color:#e54e53;" onclick="mytheme(3)"> </button>
                    <button class="color" style="background-color:#1abc9c;" onclick="mytheme(4)"> </button>
                    <button class="color" style="background-color:#159eee;" onclick="mytheme(5)"> </button>
                </div>
            </div>

        </div>
        <a class="open" href="#"><span><i class="fa fa-gear fa-spin"></i></span></a>
    </div>
	<div class="final">
	<div class="alerta">
	  <% if (request.getAttribute("msg") != null) {%>
                                <p style="color: red">
                                    <%= request.getAttribute("msg")%>
                                </p>
                                <% } %>
                                <% if (request.getAttribute("msg2") != null) {%>
                                <p style="color: green;">
                                    <%= request.getAttribute("msg2")%>
                                </p>
                                <% }%>
	<p><img src="img/confirmado.png" width=42 height=42>  Chamado <span></span> criado com sucesso!</p>
	</div>
	
	</div>
	
</body>

</html>