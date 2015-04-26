
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
        <g:form name="recherche" class="form-inline" method="get"  url="[controller:'musee',action:'doSearchMusee']">
            <div class="form-group col-lg-3">
                <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom du musée" value="${nom}">
            </div>
            <div class="form-group col-lg-3">
                <g:select id="type"
                          name="codePostal"
                          value="${codePostal}"
                          noSelection="${['null':'Choisir un code postal...']}"
                          from='${codePostalList}'
                          optionKey="id" optionValue="codePostal"
                          keys="${codePostalList?.codePostal}"
                          class="form-control">

                </g:select>
            </div>
            <div class="form-group col-lg-3">
                <input type="text" class="form-control" name="rue" id="rue" placeholder="Adresse du musée" value="${rue}">
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

                    <g:form name="favoris_form" method="post" url="[controller:'musee', action:'ajouterFavoris']">
                        <input type="hidden" id="id" name="id" value="${musee.id}" />
                        <input type="hidden" id="nomF" name="nom" value="${nom}">
                        <input type="hidden" id="rueF" name="rue" value="${rue}">
                        <input type="hidden" id="codePostalF" name="codePostal" value="${codePostal}">
                        <g:if test="${favorisList.keySet().contains((int) musee.id).booleanValue()}">
                            <input type="submit" class="btn btn-success btn-sm pull-right" value="Ajouter aux favoris" disabled />
                        </g:if>
                        <g:else>
                            <input type="submit" class="btn btn-success btn-sm pull-right" value="Ajouter aux favoris" />
                        </g:else>
                    </g:form>
                </div>

            </div>
            <span><b>Adresse</b> : ${musee.adresse.numero} ${musee.adresse.rue} ${musee.adresse.codePostal} ${musee.adresse.ville}</span><br>
            <span><b>Ouverture</b> : ${musee.horairesOuverture}</span><br>
            <span><b>Géré par</b> ${musee.gestionnaire}</span>
            <div class="row">
                <div class="col-xs-4 col-sm-4">
                    <span><b>Tél</b> : ${musee.telephone}</span>
                </div>
                <div class="col-xs-4 col-sm-4">
                    <span><b>Bus</b> : ${musee.accesBus}</span>
                </div>
                <div class="col-xs-4 col-sm-4">
                    <span><b>Metro</b> : ${musee.accesMetro}</span>
                </div>
            </div>
        </div>
    </g:each>
        <g:paginate next=" Suivant" prev="Précédent "
                    maxsteps="5" controller="musee"
                    action="doSearchMusee" total="${museeInstanceCount}" params="${params}"/>
    </g:if>
    </body>
</html>
