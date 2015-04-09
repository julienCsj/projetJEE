
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
<<<<<<< HEAD
		<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-musee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="telephone" title="${message(code: 'musee.telephone.label', default: 'Telephone')}" />
					
						<g:sortableColumn property="accesMetro" title="${message(code: 'musee.accesMetro.label', default: 'Acces Metro')}" />
					
						<g:sortableColumn property="accesBus" title="${message(code: 'musee.accesBus.label', default: 'Acces Bus')}" />
					
						<th><g:message code="musee.adresse.label" default="Adresse" /></th>
					
						<th><g:message code="musee.gestionnaire.label" default="Gestionnaire" /></th>
					
						<g:sortableColumn property="horairesOuverture" title="${message(code: 'musee.horairesOuverture.label', default: 'Horaires Ouverture')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${museeInstanceList}" status="i" var="museeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "telephone")}</g:link></td>
					
						<td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "adresse")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "gestionnaire")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${museeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
=======
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
>>>>>>> dev-julien
</html>
