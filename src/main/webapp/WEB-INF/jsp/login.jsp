<%@ include file="header.jsp" %>
<c:url var="login" value="/loginPage"/>
<c:url var="register" value="/register"/>

<div class="container d-flex h-100 mt-5 d-flex justify-content-center"><h1> Se connecter </h1></div>
<form method="post" action="${login}">
    <fieldset>
        <div class="form-group container w-25 p-3 mt-5">
            <label>Email</label>
            <input type="email" class="form-control" id="email" name="username" aria-describedby="emailHelp" placeholder="Enter email">
        </div>
        <div class="form-group container w-25 p-3">
            <label>Mot de passe</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <sec:csrfInput />
        <div class="d-flex justify-content-center"><small><button type="submit" class="btn btn-primary">Valider</button></small></div>
        <div class="d-flex justify-content-center"><small><a href="${register}">S'inscrire</a></small></div>
    </fieldset>
</form>
<%@ include file="footer.jsp" %>