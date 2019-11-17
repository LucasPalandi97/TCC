<%@page import="org.hibernate.criterion.Disjunction"%>
<%@page import="org.hibernate.criterion.Criterion"%>
<%@page import="java.util.List"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="pojo.User"%>
<%@page import="org.hibernate.Session"%>
<!DOCTYPE html>
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
<html>

    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <meta http-equiv="Content-Language" content="pt-br">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Requisi��o</title>
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

                                <label  value="NomeUser" >Ol�, <%= userName%><h1></h1></label>
                            </div>
                        </div>

                        <div id="navbar" class="collapse navbar-collapse navbar-right">

                            <ul class="nav navbar-nav">

                                <li><a href="home.jsp">In�cio</a></li>
                                <li><a href="requisicao.jsp">Requisi��o</a></li>
                                <li><a href="incidente.jsp">Incidentes</a></li>                                                         
                                <li><a href="userRegistration.jsp">Cadastrar Usu�rio (ADM)</a></li>
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
                    <h2>Crie o chamado de <span>requisi��o</span></h2>
                    <p class="subheading">Os campos com * s�o de preenchimento obrigat�rio.</p>
                </div>
                <div class="row contact-wrap">
                    <div class="status alert alert-success" style="display: none"></div>
                    <div class="col-sm-5 col-sm-offset-1">
                    <form id="main-contact-form" class="contact-form" name="contact-form" method="post" action="ReqRegistration">
                        <c:forEach var="listar" items="${listUser}">
                          <div class="form-group">
                                <label>Nome</label>
                                <input type="text" name="usernameReq" class="form-control"value="${listar.name}"readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" name="emailreq" class="form-control"value="${listar.email}"readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>Telefone</label>
                            <input type="text" name="telefonereq"class="form-control"value="${listar.telefone}"readonly="readonly">
                        </div>
                   </c:forEach> 
                        
                            <div class="form-group">
                                <label>Data *</label>
                                <input type="date" name="data" class="form-control" required="required" >
                            </div>                     

                        </div>	

                        <div class="col-sm-5">
                            <div class="form-group">
                                <div class="form-group">
                                    <label>T�tulo *</label>
                                    <input type="text" name="titulo" class="form-control" required="required">
                                </div>
                                <label>Categoria *</label>

                                <select id="catOpt" name="catOpt" class="form-control" required="required">

                                    <option value="Hardware">Hardware</option>
                                    <option value="Software">Software</option>
                                    <option value="Rede">Rede</option>
                                    <option value="" selected></option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Subcategoria *</label>

                                <select id="subcatOpt" name="subcatOpt" class="form-control" required="required">

                                    <option value="Compra">Compra</option>
                                    <option value="Instala��o">Instala��o</option>
                                    <option value="Realoca��o">Realoca��o</option>
                                    <option value="Manuten��o">Manuten��o</option>
                                    <option value="Cria��o de e-mail">Cria��o de e-mail</option>
                                    <option value="Outros">Outros</option>
                                    <option value="" selected></option>
                                </select>

                            </div>

                            <div class="form-group">
                                <label>Prioridade *</label>
                                <select id="priOpt" name="priOpt" class="form-control" required="required">

                                    <option value="Muito alta">Muito alta</option>
                                    <option value="Alta">Alta</option>
                                    <option value="M�dia">M�dia</option>
                                    <option value="Baixa">Baixa</option>
                                    <option value="Muito baixa" selected>Muito baixa</option>
                                </select>

                            </div>
                            <div class="form-group">
                                <label>Descri��o da requisi��o *</label>
                                <textarea name="descricao" id="message" required="required" class="form-control" rows="8" ></textarea>
                            </div>
                            <div class="form-group">
                                <button type="submit" name="submit" value="Register Requisicao" class="btn btn-default submit-button">Enviar chamado <i class="fa fa-caret-right"></i></button>
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