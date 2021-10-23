<%@ include file="header.jsp" %>
<c:url var="contactAdding" value="/contact/add"/>

<h2>Ajouter un contact</h2>

<form:form method="POST" action="${contactAdding}" modelAttribute="contact">
    <fieldset>

        <div class="form-group">
            <label for="firstName">Firstname</label>
            <input type="text" class="form-control" id="firstName" name="firstName" value="${contact.firstName}">
            <form:errors path="firstName" element="div" cssClass="alert-danger"/>
        </div>

        <div class="form-group">
            <label for="lastName">Lastname</label>
            <input type="text" class="form-control" id="lastName" name="lastName" value="${contact.lastName}">
            <form:errors path="lastName" element="div" cssClass="alert-danger"/>
        </div>

        <div class="form-group row">
            <label for="telephone">Telephone</label>
            <input type="text" class="form-control" id="telephone" name="telephone" value="${contact.telephone}">
            <form:errors path="telephone" element="div" cssClass="alert-danger"/>
        </div>

        <sec:csrfInput />
        <button type="submit" class="btn btn-primary">Valider</button>
    </fieldset>
</form:form>
<%@ include file="footer.jsp" %>