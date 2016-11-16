<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Registros</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            body {
                padding-top: 50px;
                padding-bottom: 20px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body onfocus="updateHistory()" onmousemove="updateHistory()" onunload="updateHistory()">
        <script>
            function updateHistory(){
                /*var tagResults = document.getElementById("results");
                var tblBody = document.getElementById("tblBody");

                tblBody.removeChild(tagResults);
                var newDiv = document.createElement("div");
                newDiv.id = "results";
                tblBody.appendChild(newDiv);
                */
               
                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8084/proyecto_feria_final_netbeans/update.do?h=1',
                }).done(function(respuesta){
                    $("#tblBody").html(respuesta);
                });
            }
            
        </script>
        
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">Proyecto Feria</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <a class="navbar-brand" href="registro.jsp">Registros</a>

        </div><!--/.navbar-collapse -->
      </div>
    </nav>
        

    <div class="jumbotron">
        <div class="container">

            <table class="table table-inverse"> 
                <thead>
                    <tr>
                        <th>Pin Sensor</th>
                        <th>Nombre</th>
                        <th>Valor</th>
                        
                    </tr>
                </thead>
                <tbody id="tblBody">
                </tbody>
            </table>
        </div>
    </div>


      <hr>

      <footer>
        <p>&copy; Instituto Profesional Santo Tomas</p>
      </footer>
     <!-- /container -->        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

        <script src="js/vendor/bootstrap.min.js"></script>

        <script src="js/main.js"></script>

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='//www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
        </script>
    </body>
</html>
