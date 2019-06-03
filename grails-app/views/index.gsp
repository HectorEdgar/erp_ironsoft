<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>S.E.C.O</title>
</head>
<body>

<h3><sec:ifLoggedIn>Bienvenido:<i> <sec:username/></i></sec:ifLoggedIn></h3>




<sec:ifNotLoggedIn>
    Inicia Sesión
    <li class="dropdown user user-menu">
        <g:link class="btn text-blue" uri="/login/auth">Iniciar sesión</g:link>
    </li>
</sec:ifNotLoggedIn>

</body>
</html>
