<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container my-4">
    <h2 class="text-center">Créer un Compte</h2>
    <form action="RegisterServlet" method="post">
        <div class="form-group">
            <label for="name">Nom:</label>
            <input type="text" name="name" id="name" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="password">Mot de passe:</label>
            <input type="password" name="password" id="password" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="address">Adresse:</label>
            <input type="text" name="address" id="address" class="form-control">
        </div>
        <div class="form-group">
            <label for="phone">Téléphone:</label>
            <input type="text" name="phone" id="phone" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">S'inscrire</button>
    </form>
</div>