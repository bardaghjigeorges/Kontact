<%@ include file="header.jsp" %>
<c:url var="login" value="/login"/>
<c:url var="contactEdit" value="/contact/edit"/>
<c:url var="contactDelete" value="/contact/delete"/>

<div class="container-sm" style="margin-top: 10px">


    <div class="d-flex flex-row flex-wrap justify-content-center container d-flex h-100 mt-5 card-columns w-25">
        <sec:authorize access="isAuthenticated()">
            <c:forEach items="${contacts}" var="contact">
                <div class="card" style="margin-top: 10px">
                    <div class="card-body">
                        <h5 class="card-title">${contact.firstName} ${contact.lastName}</h5>
                        <p class="card-text">${contact.telephone}</p>
                        <a href="${contactEdit}/${contact.id}" class="btn btn-primary">Modifier</a>
                        <a href="${contactDelete}/${contact.id}" class="btn btn-danger">Supprimer</a>
                    </div>
                </div>
            </c:forEach>
        </sec:authorize>
    </div>
</div>

<%@ include file="footer.jsp" %>