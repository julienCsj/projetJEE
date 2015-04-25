<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Toulouse Musées</title>

    <!-- Bootstrap -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="//getbootstrap.com/examples/offcanvas/offcanvas.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Toulouse Musée</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Accueil</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->

<div class="container">

    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
            <g:layoutBody/>
        </div><!--/.col-xs-12.col-sm-9-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
            <h3>Musées préférés</h3>
        <div id="favoris" class="list-group">
            <g:each var="musee" in="${favorisList}">
                <div class="list-group-item">
                    ${musee.nom}
                    <g:form name="favoris_form" method="post" url="[controller:'musee', action:'supprimerFavoris']">
                        <input type="hidden" id="id" name="id" value="${musee.id}" />
                        <input type="hidden" id="nomF" name="nom" value="${nom}">
                        <input type="hidden" id="rueF" name="rue" value="${rue}">
                        <input type="hidden" id="codePostalF" name="codePostal" value="${codePostal}">
                        <input type="hidden" id="index" name="index" value="${index}">
                        <input type="submit" class="btn btn-danger btn-sm pull-right" value="Supprimer" />
                    </g:form>
                    <g:link class="btn btn-success btn-sm pull-right" controller="demandeVisiteMusee" action="getForm" id="${favoris.id}">Demande de visite</g:link>
                </div>
            </g:each>

        </div>
        </div><!--/.sidebar-offcanvas-->
    </div><!--/row-->

    <hr>

    <footer>
        <p>&copy; Elliot Felgines & Julien Custoja</p>
    </footer>

</div><!--/.container-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</body>
</html>

