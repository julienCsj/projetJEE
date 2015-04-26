
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>
<body>

<h4>Effectuer une demande de visite</h4>
<g:form name="demandeVisite" class="form-" method="post"  url="[controller:'demandeVisiteMusee',action:'doAjoutDemande']">
    <p>Vous souhaitez effectuer une demande de visite pour le musée : ${musee.nom}</p>

    <g:if test="${message}">
        <div class="alert alert-danger" role="alert">
            <ul>
                <g:each var="m" in="${message}">
                    <li>${m}</li>
                </g:each>
            </ul>
        </div>
    </g:if>

    <input type="hidden" class="form-control" name="idMusee" value="${musee.id}" />

    <div class="form-group">
        <label for="dateD">Date début période :</label>
        <g:datePicker id="dateD" class="form-control" name="dateDebut" value="${dateDebut? dateDebut : new Date()}" precision="day"
                      noSelection="['':'-Choisir-']" relativeYears="[0..1]" />
    </div>



    <div class="form-group">
        <label for="dateF">Date fin période :</label>
        <g:datePicker id="dateF" class="form-control" name="dateFin" value="${dateFin? dateFin : new Date()}" precision="day"
                      noSelection="['':'-Choisir-']" relativeYears="[0..1]" />
    </div>

    <div class="form-group">
        <label for="nb">Nombre de personnes :</label>
        <input id="nb" type="number" class="form-control" name="nbPersonnes" value="${nbPersonnes}"/>

    </div>

    <button type="submit" class="btn btn-default col-lg-3">Effectuer la demande</button>
</g:form>
</body>
</html>
