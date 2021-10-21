<%@ include file="header.jsp" %>
<c:url var="login" value="/login"/>

<div class="container-sm" style="margin-top: 10px">

    <sec:authorize access="!isAuthenticated()">
        <a href="/group/${login}" class="btn btn-primary">Se connecter</a>
    </sec:authorize>
    <div class="d-flex flex-row flex-wrap justify-content-around">
        <sec:authorize access="isAuthenticated()">
            <c:forEach items="${contacts}" var="contact">
                <div class="card" style="margin-top: 10px">
                    <div class="card-body">
                        <h5 class="card-title">${contact.firstname} ${contact.lastname}</h5>
                        <p class="card-text">${contact.telephone}</p>
                        <a href="/user/${contact}/edit" class="btn btn-primary">Modifier</a>
                    </div>
                </div>
            </c:forEach>
        </sec:authorize>
    </div>
</div>

<%@ include file="footer.jsp" %>