<%-- 
    Document   : incidentes
    Created on : 20/10/2019, 19:28:24
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
                                    String userName = null;
                                    Cookie[] cookies = request.getCookies();
                                    if (cookies != null) {
                                        for (Cookie cookie : cookies) {
                                            if (cookie.getName().equals("username")) {
                                                userName = cookie.getValue();
                                            }
                                        }
                                    }
                                    if (userName == null) {
                                        response.sendRedirect("login.jsp");
                                    }
                                %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Incidente</title>
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
							<label  value="NomeUser" >Olá, <%=userName%><h1></h1></label>
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

    <section id="contact-page">
        <div class="container">
            <div class="section-heading text-center">
                <h2>Crie o chamado de <span>incidente</span></h2>
                <p class="subheading">Os campos com * são de preenchimento obrigatório.</p>
            </div>
            <div class="row contact-wrap">
                <div class="status alert alert-success" style="display: none"></div>
                <form id="main-contact-form" class="contact-form" name="contact-form" method="post" action="sendemail.php">
                    <div class="col-sm-5 col-sm-offset-1">
                       
						<div class="form-group">
                            <label>Data *</label>
                            <input type="text" class="form-control" required="required">
                        </div>
                        <div class="form-group">
                            <label>Setor</label>
                            <input type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Título *</label>
                            <input type="text" name="subject" class="form-control" required="required">
                        </div>
						<div class="form-group">
                            <label>Número de série (Computadores e Periféricos)</label>
                            <input type="text" name="subject" class="form-control">
                        </div>
						
						</div>
						<div class="col-sm-5">
						<div class="form-group">
                            <label>Categoria *</label>

							<select class="form-control" required="required">
							
							<option value="valor1">Hardware</option>
							<option value="valor2">Software</option>
							<option value="valor3">Rede</option>
							<option value="valor4" selected></option>
							</select>

                        </div>
						<div class="form-group">
                            <label>Subcategoria *</label>

							<select class="form-control" required="required">
							
							<option value="valor1">Conexão de internet/wi-fi</option>
							<option value="valor2">Telefone</option>
							<option value="valor3">Quebra de equipamentos</option>
							<option value="valor4">Falha de equipamentos</option>
							<option value="valor5">Erro de software</option>
							<option value="valor6">Impressora</option>
							<option value="valor7">Outros</option>
							<option value="valor8" selected></option>
							</select>

                        </div>
						<div class="form-group">
                            <label>Outros (Subcategoria) *</label>
                            <input type="text" name="subject" class="form-control" required="required">
                        </div>
						
						<div class="form-group">
                            <label>Prioridade *</label>
                            <select class="form-control" required="required">
							
							<option value="valor1">Muito alta</option>
							<option value="valor2">Alta</option>
							<option value="valor3">Média</option>
							<option value="valor4">Baixa</option>
							<option value="valor5"selected>Muito baixa</option>
							</select>
							
                        </div>
                        <div class="form-group">
                            <label>Descrição da requisição *</label>
                            <textarea name="message" id="message" required="required" class="form-control" rows="8"></textarea>
                        </div>
                        <div class="form-group">
                            <button type="submit" name="submit" class="btn btn-default submit-button">Enviar chamado <i class="fa fa-caret-right"></i></button>
                        </div>
                    </div>
                </form>
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
</body>

</html>