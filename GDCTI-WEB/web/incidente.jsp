<%-- 
    Document   : incidentes
    Created on : 20/10/2019, 19:28:24
    Author     : lucas
--%>

<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="pojo.User"%>
<%@page import="pojo.User"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
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
                                <%
    Session sessao = HibernateUtil.getSession();
    Criteria crit = sessao.createCriteria(User.class);
    crit.add(Restrictions.eq("username", userName));
    List<User> infolist = crit.list();
    request.getSession().setAttribute("listUser", infolist);

%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <meta http-equiv="Content-Language" content="pt-br">
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

                                <label  value="NomeUser" >Olá, <%= userName%><h1></h1></label>
                            </div>
                        </div>

                        <div id="navbar" class="collapse navbar-collapse navbar-right">

                            <ul class="nav navbar-nav">

                                <li><a href="home.jsp">Início</a></li>
                                <li><a href="requisicao.jsp">Requisição</a></li>
                                <li><a href="incidente.jsp">Incidentes</a></li>                                                         
                                <li><a href="userRegistration.jsp">Cadastrar Usuário (ADM)</a></li>
                                <li><form action="logout" method="post">
                                        <input style="margin-left: 50%" name="submit" class="btn btn-default submit-button" type="submit" value="Sair">
                                    </form>				
                            </ul>

                        </div>

                    </div>

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
                <form id="main-contact-form" class="contact-form" name="contact-form" method="post" action="IncRegistration">
                    <div class="col-sm-5 col-sm-offset-1">
                        <c:forEach var="listar" items="${listUser}">
                        <div class="form-group">
                            <label>Nome</label>
                            <input type="text" name="nameinc" class="form-control" value="${listar.name}"readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>Email</label>                         
                            <input class="form-control"  type="text" name="emailinc"  value="${listar.email}"readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>Telefone</label>
                            <input type="tel" name="telefoneinc"class="form-control"value="${listar.telefone}"readonly="readonly">
                        </div>
                        </c:forEach>
			<div class="form-group">
                            <label>Data *</label>
                            <input  type="date" name="data" class="form-control" required="required">
                        </div>     
                        <div class="form-group">
                            <label>Número de série (Computadores e Periféricos)</label>
                            <input type="text" name="serie" class="form-control">
                        </div>
					
                        </div>	
						
						<div class="col-sm-5">
						<div class="form-group">
                                                <div class="form-group">
                            <label>Título *</label>
                            <input type="text" name="titulo" class="form-control" required="required">
                              </div>
                            <label>Categoria *</label>

							<select id="catOpt2" name="catOpt2" class="form-control" required="required">
							
							<option value="Hardware">Hardware</option>
							<option value="Software">Software</option>
							<option value="Rede">Rede</option>
                                                        <option value="Outros">Outros</option>
							<option value="" selected></option>
							</select>
</div>
                       
						<div class="form-group">
                            <label>Subcategoria *</label>

							<select id="subcatOpt2" name="subcatOpt2" class="form-control" required="required">
							
							<option value="Conexão de internet/wi-fi">Conexão de internet/wi-fi</option>
							<option value="Telefone">Telefone</option>
							<option value="Dano ou Quebra">Dano ou Quebra</option>
                                                        <option value="Falha">Falha</option>
							<option value="Erros">Erros</option>
							<option value="Impressora">Impressora</option>
                                                        <option value="Outros">Outros</option>
							<option value="" selected></option>
							</select>

                        </div>
						
						<div class="form-group">
                            <label>Prioridade *</label>
                            <select id="priOpt2" name="priOpt2" class="form-control" required="required">
							
							<option value="Muito alta">Muito alta</option>
							<option value="Alta">Alta</option>
							<option value="Média">Média</option>
							<option value="Baixa">Baixa</option>
							<option value="Muito baixa"selected>Muito baixa</option>
							</select>
							
                        </div>
                        <div class="form-group">
                            <label>Descrição da requisição *</label>
                            <textarea name="descricao" id="message" required="required" class="form-control" rows="8"></textarea>
                        </div>
                        <div class="form-group">
                            <button type="submit" name="submit" value="Register Incidente" class="btn btn-default submit-button">Enviar chamado <i class="fa fa-caret-right"></i></button>
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