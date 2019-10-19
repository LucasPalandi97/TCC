<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
         <meta http-equiv="Content-Language" content="pt-br">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta charset="ISO-8859-1">
        <title>Login - HELPER</title>
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
                    <div class="navbar-header">

                        <a class="navbar-brand" href="#">
                            <h1>HELPER</h1><span>GERENCIADOR DE CHAMADOS DE T.I.</span></a>
                      
                    </div>

                    <!--/.nav-collapse -->
                </div>
            </nav>
            <!--/.nav-ends -->
        </header>


        <section id="login-reg">
            <div class="container">
                <!-- Top content -->
                <div class="row">
                    <div class="col-md-6 col-sm-12 forms-right-icons">




                    </div>
                    <div class="col-md-6 col-sm-12">

                        <div class="form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Faça seu login:</h3>
                                    <p>Entre com usuário e senha:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-key"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
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
                                <form role="form" action="login" class="login-form" method="POST">
                                    <div class="input-group form-group">
                                        <span class="input-group-addon" id="basic-addon1"><i class="fa fa-user"></i></span>
                                        <input type="text" name="username" required="required" class="form-control" placeholder="Usuário" aria-describedby="basic-addon1">
                                    </div>
                                    <div class="input-group form-group">
                                        <span class="input-group-addon" id="basic-addon1"><i class="fa fa-unlock"></i></span>
                                        <input type="password" name="password" required="required" class="form-control" placeholder="Senha" aria-describedby="basic-addon1">
                                    </div>
                                    <button type="submit" class="btn">Entrar!</button>
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

                        </html>