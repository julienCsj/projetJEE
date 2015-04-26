
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>
<body>

<h4>Effectuer une demande de visite</h4>
    <p>Vous avez effectué une demande de visite pour le musée : ${dvm.musee.nom}</p>
    <p>Cette demande (${dvm.demandeVisite.code}) est validé pour la période du <g:formatDate format="dd-MM-yyyy" date="${dvm.demandeVisite.dateDebutPeriode}"/> au <g:formatDate format="dd-MM-yyyy" date="${dvm.demandeVisite.dateFinPeriode}"/> pour ${dvm.demandeVisite.nbPersonnes} personnes.</p>
</body>
</html>
