<%@ include file="header.jsp" %>
<c:url var="login" value="/login"/>
<c:url var="register" value="/register"/>

<h2> S'inscrire </h2>
<form method="post" action="${register}">
    <fieldset>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email">

        </div>

        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>

        <small><a href="${login}">J'ai deja un compte</a></small>
        <sec:csrfInput />
        <button type="submit" class="btn btn-primary" id="submit" name="submit">Submit</button>


    </fieldset>
</form>
<%@ include file="footer.jsp" %>