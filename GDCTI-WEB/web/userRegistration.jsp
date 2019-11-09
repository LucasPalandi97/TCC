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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <meta http-equiv="Content-Language" content="pt-br">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/skin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="./script/index.js"></script>
        <title>User Registration</title>
    </head>
    <body>
        </br></br></br></br>
        <h2 align="center">
            <% if (request.getAttribute("msg2") != null) {%>
            <p style="color: red">
                <%= request.getAttribute("msg2")%>
            </p>
            <% } %>
        </h2>
        <div align="center">
            <form action="userRegistration" method="post">
                <table align="center" border="1">
                    <tr>
                        <td colspan="2" align="center"><b>User Registration</b></td>
                    </tr>
                    <tr>
                        <td>Login* :</td>
                        <td><input type="text" name="username" required></td>
                    </tr>
                    <tr>
                        <td>Senha* :</td>
                        <td><input type="password" name="password" required></td>
                    </tr>
                    <tr>
                        <td>Conform Password* :</td>
                        <td><input type="password" name="confPassword" required></td>
                    </tr>
                    <tr>
                        <td>Nome* :</td>
                        <td><input type="text" name="name" required></td>
                    </tr>
                    <tr>
                        <td>Função* :</td>
                        <td><select id="funcao" name="funcao" required>
                                <option value="analista">Analista</option>
                                <option value="funcionario">Funcionário</option>
                                <option value="adm">Administrador</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>E-mail* :</td>
                        <td><input type="text" name="email" required></td>
                    </tr>
                    <tr>
                        <td>Telefone* :</td>
                        <td><input type="number" name="telefone" required></td>
                    </tr>
                    <tr>
                        <td align="center"><input type="submit" value="Register User"></td>
                        <td align="center"><input type="reset" name="Reset Form"></td>
                    </tr>
                </table>   
            </form>
            <form action="consultaUser" method="post">
                <td align="center"><input type="submit" value="Select User"></td>
                <c:forEach var="item" items="${list}" > 
                    <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 portfolio-item">
                    <div class="portfolio-one">
                        <div class="portfolio-head">
                            <div class="portfolio-img"><img alt="" src="img/chamados.png"></div>
                            <div class="portfolio-hover">                               
                            </div>
                        </div>
                        <!-- End portfolio-head -->
                        <div class="portfolio-content">
                            <h5 class="title"> <td> ${item.username}</td><br> </h5>
  
            <td> ${item.name}</td><br>   
            <td> ${item.email}</td><br>   
            <td> ${item.telefone}</td><br>   
            <td> ${item.funcao}</td><br>   
            <td> ${item.password}</td><br>       
                        </div>
                        <!-- End portfolio-content -->
                    </div>
                    <!-- End portfolio-item -->
                </div>
                </c:forEach>
              
            </form>
        </div>
    </body>
</html>