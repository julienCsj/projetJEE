
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>
<body>

<h4>Information sur votre demande de visite</h4>
<ul>
<li>Musée : ${dvm.musee.nom}</li>
<li>Nombre de personne : ${dvm.demandeVisite.nbPersonnes}</li>
<li>Date de dépot de la demande : <g:formatDate format="dd-MM-yyyy" date="${dvm.dateDemande}"/></li>
<g:if test="${dvm.demandeVisite.statut == toulousemusee.DemandeVisite.Statut.CONFIRME}">
    <li>Début période : <g:formatDate format="dd-MM-yyyy" date="${dvm.demandeVisite.dateDebutPeriode}"/></li>
    <li>Fin période : <g:formatDate format="dd-MM-yyyy" date="${dvm.demandeVisite.dateFinPeriode}"/></li>
</g:if>
<li>STATUT : ${dvm.demandeVisite.statut}<g:if test="${dvm.demandeVisite.statut == toulousemusee.DemandeVisite.Statut.REFUSE}">Aucun guide	disponible sur cette période</g:if></li>
</ul>

</body>
</html>
