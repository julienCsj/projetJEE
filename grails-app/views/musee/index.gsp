
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
        <g:form name="myForm" class="form-inline" url="[controller:'musee',action:'doSearchMusee']">
            <div class="form-group">
                <label for="nom">Nom du musée</label>
                <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom du musée" value="">
            </div>
            <div class="form-group">
                <label for="codePostal">Code postal</label>
                <select class="form-control" placeholder="Selectionner le code postal" id="codePostal" name="codePostal">
                    <option value="">Choisir un CP</option>
                    <g:each var="adresse" in="${codePostalList}">
                       <option value="${adresse.codePostal}">${adresse.codePostal}</option>
                    </g:each>
                </select>
            </div>
            <div class="form-group">
                <label for="rue">Adresse</label>
                <input type="text" class="form-control" name="rue" id="rue" placeholder="Adresse du musée" value="">
            </div>
            <button type="submit" class="btn btn-default">Rechercher</button>
        </g:form>
    </body>
</html>
