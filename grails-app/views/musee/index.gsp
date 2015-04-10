
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>

        <div class="jumbotron">
            <h1>Bienvenue sur Toulouse Musée !</h1>
            <p>Cette application a été réalisée dans le cadre de l'UE JEE du Master 1 Développement Logiciel de l'Université Paul Sabatier.</p>
        </div>

        <h4>Rechercher un musée</h4>
        <g:form name="recherche" class="form-inline"  url="[controller:'musee',action:'doSearchMusee']">
            <div class="form-group col-lg-3">
                <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom du musée" value="">
            </div>
            <div class="form-group col-lg-3">
                <select class="form-control" placeholder="Selectionner le code postal" id="codePostal" name="codePostal">
                    <option value="">Selectionner le code postal</option>
                    <g:each var="adresse" in="${codePostalList}">
                       <option value="${adresse.codePostal}">${adresse.codePostal}</option>
                    </g:each>
                </select>
            </div>
            <div class="form-group col-lg-3">
                <input type="text" class="form-control" name="rue" id="rue" placeholder="Adresse du musée" value="">
            </div>
            <button type="submit" class="btn btn-default col-lg-3">Rechercher</button>
        </g:form>

    <g:if test="${museeInstanceList}">
        <br><br>
        <h4>Résultat de la recherche</h4>
    <g:each var="musee" in="${museeInstanceList}">
        <div class="well">
            <div class="row">
                <div class="col-xs-11 col-sm-11">
                    <h4>${musee.nom}</h4>
                </div>
                <div class="col-xs-1 col-sm-1">
                    <g:link controller="musee" action="ajouterFavoris"
                            params="[musee:musee]">
                        <button class="btn btn-success btn-sm pull-right">Ajouter aux favoris</button>
                    </g:link>

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
        </g:if>
    </body>
</html>
