
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <meta http-equiv="Content-Language" content="pt-br">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Início</title>
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
        </header>
        <!--/.nav-ends -->
        <div id="myCarousel" class="carousel slide">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <div class="fill" style="background-image:url('img/banner-slide-1.jpg');"></div>
                    <div class="carousel-caption slide-up">
                        <h1 class="banner_heading">Provendo a <span> melhor </span>solução</h1>
                        <p class="banner_txt">Transformando os problemas em soluções: o sucesso se encontra aqui!</p>                   
                    </div>
                </div>



                <section id="top_banner">

            </div>
        </section>



        <section id="portfolio">
            <div class="container">
                <div class="row">
                    <div class="section-heading text-center">
                        <div class="col-md-12 col-xs-12">
                            <h1>Visualize os chamados <span>aqui:</span></h1>
                        </div>
                    </div>
                </div>
                <div align="center">
                </div>
                <br>
                <div class="row">
                    <form  method="post">
                        <div align="center">
                            <td align="center"><input  formaction="consultaRequisicao" name="submit" class="btn btn-default submit-button" type="submit" value="Requisições"></td>
                            <td align="center"><input formaction="consultaIncidente" name="submit" class="btn btn-default submit-button" type="submit" value="Incidentes"></td>  
                        </div>
                        <br>
                        <c:forEach var="item" items="${list}"  > 

                            <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 portfolio-item">
                                <div class="portfolio-one">
                                    <div class="portfolio-head">
                                        <div class="portfolio-img"><img alt="" src="img/chamados.png"></div>
                                        <div class="portfolio-hover">                               
                                        </div>
                                    </div>
                                    <!-- End portfolio-head -->
                                    <div class="portfolio-content">
                                        <h5 class="title"> <td> ${item.titulo}</td><br> </h5>

                                        <li><span style="font-weight: bold">Chamado: </span>${item.tipo}${item.id}</li>               
                                        <li><span style="font-weight: bold">Status: </span>${item.status}</li> 
                                        <li><span style="font-weight: bold">Prioridade: </span> ${item.prioridade}</li>       
                                        <li><span style="font-weight: bold">Data: </span>${item.data}</li>   
                                        <li><span style="font-weight: bold">Categoria: </span>${item.categoria}</li>
                                        <li><span style="font-weight: bold">Subcategoria: </span>${item.subcategoria}</li>                       
                                        <li><span style="font-weight: bold">Descrição: </span>${item.descricao}</li>


                                    </div>
                                    <!-- End portfolio-content -->
                                </div>
                                <!-- End portfolio-item -->
                            </div>
                        </c:forEach>

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