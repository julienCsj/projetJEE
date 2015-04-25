
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>
<body>

<h4>Effectuer une demande de visite</h4>
<g:form name="demandeVisite" class="form-" method="post"  url="[controller:'demandeVisiteMusee',action:'doAjoutDemande']">
    <p>Vous souhaitez effectuer une demande de visite pour le musée : ${musee.nom}</p>

    <g:if test="${errors}">
        <div class="alert alert-danger" role="alert">${errors}</div>
    </g:if>

    <input type="hidden" class="form-control" name="idMusee" value="${musee.id}" />

    <div class="form-group">
        <label for="dateDebut">Date début période :</label>
        <g:datePicker id="dateDebut" class="form-control" name="dateDebut" value="${dateDebut}" precision="day"
                      noSelection="['':'-Choisir-']" relativeYears="[0..1]" />
    </div>


    <div class="form-group">
        <label for="dateFin">Date fin période :</label>
        <g:datePicker id="dateFin" class="form-control" name="dateFin" value="${dateFin}" precision="day"
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
