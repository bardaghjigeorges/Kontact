<c:url var="contactsList" value="/home"/>
<c:url var="contactAdding" value="/contact/add"/>
<c:url var="login" value="/login"/>
<c:url var="logout" value="/logout"/>



<nav class="navbar navbar-expand-lg navbar-dark bg-primary" >

    <a class="navbar-brand mr-auto" href="${contactsList}"><h1>Kontact</h1></a>
    <sec:authorize access="isAuthenticated()">
    <a class="navbar-brand" href="${contactAdding}"><h3>Nouveau contact +</h3></a>
    <a class="navbar-brand ml-auto" href="${logout}"><h5>Deconnexion</h5></a>
    </sec:authorize>

</nav>


