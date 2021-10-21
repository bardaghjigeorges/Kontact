<%@ include file="header.jsp" %>
<c:url var="contactEdit" value="/user/contact/edit"/>

<h2>Modifier le contact</h2>

<form:form method="POST" action="${contactEdit}" modelAttribute="contact">
    <fieldset>

        <div class="form-group">
            <label for="firstname">Firstname</label>
            <input type="text" class="form-control" id="firstname" name="firstname" value="${user.contact.firstname}">
            <form:errors path="firstname" element="div" cssClass="alert-danger"/>
        </div>

        <div class="form-group">
            <label for="lastname">Lastname</label>
            <input type="text" class="form-control" id="lastname" name="lastname" value="${user.contact.lastname}">
            <form:errors path="lastname" element="div" cssClass="alert-danger"/>
        </div>

        <div class="form-group row">
            <label for="telephone">Group</label>
            <input type="text" class="form-control" id="telephone" name="telephone" value="${user.contact.telepone}">
            <form:errors path="telephone" element="div" cssClass="alert-danger"/>
        </div>

        <sec:csrfInput />
        <button type="submit" class="btn btn-primary">Valider</button>
    </fieldset>
</form:form>
<%@ include file="footer.jsp" %>