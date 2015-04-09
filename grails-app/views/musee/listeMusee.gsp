
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>
<body>
<h4>Résultat de la recherche</h4>
<ul>
<g:each var="musee" in="${museeInstanceList}">
    <li>${musee}</li>
</g:each>
</ul>
</body>
</html>
