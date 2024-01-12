<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Connexion</h2>
<div class="login-form">
    <c:if test="${not empty requestScope.erreur}">
        <div class="alert alert-danger">
            ${requestScope.erreur}
        </div>
    </c:if>
    
    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="password">Mot de passe:</label>
            <input type="password" name="password" id="password" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Se connecter</button>
    </form>
    <p>Pas encore inscrit ? <a href="enregistrement.jsp">Créer un compte</a></p>
</div>
