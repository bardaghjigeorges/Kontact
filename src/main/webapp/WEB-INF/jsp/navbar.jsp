<c:url var="contactsList" value="/home"/>
<c:url var="contactAdding" value="/contact/add"/>
<c:url var="login" value="/login"/>
<c:url var="logout" value="/logout"/>



<nav class="navbar navbar-expand-lg navbar-dark bg-primary" >
    <a class="navbar-brand" href="${contactsList}">Kontact</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
            aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav mr-auto">

            <sec:authorize access="isAuthenticated()">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Mon Compte</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${contactAdding}">Ajouter Contact</a>
                        <a class="dropdown-item" href="${logout}">Logout</a>
                    </div>
                </li>
            </sec:authorize>
        </ul>
        <!--
        <form class="form-inline my-2 my-lg-0" action="${findGroups}" method="get">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" name="search" size="10">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form>
        -->
    </div>
</nav>


