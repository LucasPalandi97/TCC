<%@page import="javax.swing.JOptionPane"%>
<%@page import="org.hibernate.HibernateException"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="controller.ConsultaUser"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<html>
    <head>
          <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <meta http-equiv="Content-Language" content="pt-br">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/skin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="./script/index.js"></script>
     <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/skin.css">
        <script src="./script/index.js"></script>
        <title>User Registration</title>
    </head>
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
    
    <body id="wrapper">

        <h2 align="center">
            <% if (request.getAttribute("msg2") != null) {%>
            <p style="color: red">
                <%= request.getAttribute("msg2")%>
            </p>
            <% } %>
        </h2>
   
        <div style="" class="container">
            <!-- Top content -->
            <div style="margin-top: 50px;" class="row">
               
                <!--forms-right-icons-->
                <div class="col-md-6 col-sm-12">
                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Cadastrar Usuários</h3>
                                <p>Preencha os campos abaixo para cadastrar um usuário.</p>
                            </div>
                            
                        </div>
                        <div class="form-bottom">
                            <form class="login-form" role="form" method="post">
                                <div class="input-group form-group">
                                    <span class="input-group-addon" id="basic-addon1"><i class="fa fa-user"></i></span>
                                    <input class="form-control" aria-describedby="basic-addon1" type="text" placeholder="Usuário" name="username">
                                </div>
                                <div class="input-group form-group">
                                    <span class="input-group-addon" id="basic-addon1"><i class="fa fa-user"></i></span>
                                    <input class="form-control" aria-describedby="basic-addon1" type="text" placeholder="Nome" name="name">
                                </div>
                                 <div class="input-group form-group">                                  
                                    <input class="form-control" type="password" name="password" placeholder="Senha">
                                </div> <div class="input-group form-group">                                  
                                    <input class="form-control" type="password" name="confPassword" placeholder="Confirmar senha">
                                </div>
                                <div class="input-group form-group">  
                                    <label>Função: </label> 
                                     <select class="form-control" name="funcao" id="funcao" required="">
                                <option value="analista">Analista</option>
                                <option value="funcionario">Funcionário</option>
                                <option value="adm">Administrador</option>
                            </select>
                                        
                                </div>
                                <div class="input-group form-group">
                                    <span class="input-group-addon" id="basic-addon1"><i class="fa fa-envelope"></i></span>
                                    <input class="form-control" aria-describedby="basic-addon1" type="text" placeholder="E-mail"name="email">
                                </div>
                               
                                <div class="input-group form-group">
                                    <span class="input-group-addon" id="basic-addon1"><i class="fa fa-phone"></i></span>
                                    <input class="form-control" aria-describedby="basic-addon1" type="tel" placeholder="Telefone" name="telefone">
                                </div>
                                <div align="center">
                                <input class="btn" type="submit" formaction='userRegistration' value='Cadastrar Usuário'><input class="btn" type="submit" formaction='consultaUser' value="Mostrar Usuários">
                                </div>
                                <br>
                                </form>
                            </div>
     
                        </div>
                    </div>

                </div>
            <div class="col-md-6 col-sm-12">
<div class="row">
                    
                <br>
                <div class="row">
                   
                        <c:forEach var="itemUser" items="${listUser}" > 
                            <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 portfolio-item">
                    <div class="portfolio-one">
                        <div class="portfolio-head">
                            <div class="portfolio-img"><img alt="" src="img/user.png"></div>
                            <div class="portfolio-hover">                               
                            </div>
                        </div>
                        <!-- End portfolio-head -->
                        <div class="portfolio-content">
                            <h5 class="title"> <td>Usuário:  ${itemUser.username}</td><br> </h5>
  
            <td>Nome: ${itemUser.name}</td><br>   
            <td>E-mail: ${itemUser.email}</td><br>   
            <td>Telefone: ${itemUser.telefone}</td><br>   
            <td>Função: ${itemUser.funcao}</td><br>   
            <td>Senha: ${itemUser.password}</td><br>       
                        </div>
                        <!-- End portfolio-content -->
                    </div>
                    <!-- End portfolio-item -->
                </div>
                </c:forEach>

                
                </div>
    </div>
            </div>               
        </div>
       
                
                
              
            
     
    </body>
</html>