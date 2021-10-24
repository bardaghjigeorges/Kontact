<%@ include file="header.jsp" %>
<c:url var="contactEdit" value="/contact/edit"/>

<div class="container d-flex h-100 mt-5 d-flex justify-content-center"><h1>Modifier le contact</h1></div>

<form:form method="POST" action="${contactEdit}/${contact.id}" modelAttribute="contact">
    <fieldset>

        <div class="form-group container w-25 p-3 mt-5">
            <label for="firstName">FirstName</label>
            <input type="text" class="form-control" id="firstName" name="firstName" value="${contact.firstName}">
            <form:errors path="firstName" element="div" cssClass="alert-danger"/>
        </div>

        <div class="form-group container w-25 p-3">
            <label for="lastName">LastName</label>
            <input type="text" class="form-control" id="lastName" name="lastName" value="${contact.lastName}">
            <form:errors path="lastName" element="div" cssClass="alert-danger"/>
        </div>

        <div class="form-group container w-25 p-3">
            <label for="telephone">Telephone</label>
            <input type="text" class="form-control" id="telephone" name="telephone" value="${contact.telephone}">
            <form:errors path="telephone" element="div" cssClass="alert-danger"/>
        </div>

        <sec:csrfInput />
        <div class="d-flex justify-content-center"><button type="submit" class="btn btn-primary">Valider</button></div>
    </fieldset>
</form:form>
<%@ include file="footer.jsp" %>