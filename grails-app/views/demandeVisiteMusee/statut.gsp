
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>
<body>

<h4>Effectuer une demande de visite</h4>
<g:form name="consultationDemande" class="form-" method="post"  url="[controller:'demandeVisiteMusee',action:'postFormStatut']">
    <g:if test="${message}">
        <div class="alert alert-danger" role="alert">
            <ul>
                <g:each var="m" in="${message}">
                    <li>${m}</li>
                </g:each>
            </ul>
        </div>
    </g:if>


    <div class="form-group">
        <label for="code">Code de la demande :</label>
        <input id="code" type="text" class="form-control" name="code" value="${code}"/>

    </div>

    <div class="well">
        <h5>Pour tests : </h5>
        <ul>
        <g:each var="demande" in="${listeDemande}">
            <li>${demande}</li>
        </g:each>
        </ul>
    </div>

    <button type="submit" class="btn btn-default col-lg-3">Effectuer la demande</button>
</g:form>
</body>
</html>
