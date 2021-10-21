<%@ include file="header.jsp" %>
<c:url var="login" value="/login"/>
<c:url var="register" value="/register"/>

<h2> Se connecter </h2>
<form method="post" action="${login}">
    <fieldset>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email">

        </div>
        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <small><a href="${register}">Register</a></small>
        <sec:csrfInput />
        <button type="submit" class="btn btn-primary">Submit</button>

    </fieldset>
</form>
<%@ include file="footer.jsp" %>