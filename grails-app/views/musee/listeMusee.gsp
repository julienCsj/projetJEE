
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>
<body>
<h4>Résultat de la recherche</h4>
<ul>
<g:each var="musee" in="${museeInstanceList}">
    <div class="well">
        <div class="row">
             <div class="col-xs-11 col-sm-11">
                 <h4>${musee.nom}</h4>
             </div>
            <div class="col-xs-1 col-sm-1">
                <button class="btn btn-success btn-sm pull-right">Ajouter aux favoris</button>
            </div>

        </div>
        <p>${musee.horairesOuverture}</p>
        <div class="row">
            <div class="col-xs-4 col-sm-4">
                <span class="glyphicon glyphicon-phone" aria-hidden="true">${musee.telephone}</span>

            </div>
            <div class="col-xs-4 col-sm-4">
                <span class="glyphicons glyphicons-bus" aria-hidden="true">${musee.accesBus}</span>
            </div>
            <div class="col-xs-4 col-sm-4">
                <span class="glyphicons glyphicons-train" aria-hidden="true">${musee.accesMetro}</span>
            </div>
        </div>
    </div>
</g:each>
</ul>
</body>
</html>
