<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8"> <!-- Définir l'encodage UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
    <!-- Ajoutez le lien vers Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<header>
<div class="vintage-container">
    <c:if test="${user != null}">
        <p class="vintage-greeting">Bonjour ${user.firstname} ${user.name}</p>
    </c:if>
    <a href="${pageContext.request.contextPath}/MenuServlet" class="vintage-button">ACCUEIL</a>
    <a href="${pageContext.request.contextPath}/LogoutServlet" class="vintage-button">logout</a>
    <a href="${pageContext.request.contextPath}/RecordServlet" class="vintage-button">s'inscrire</a>
    <a href="${pageContext.request.contextPath}/ChatServlet" class="vintage-button">Le chat</a>
</div>
</header>
<body>
    <div class="container text-center">
        <h3>Mon Profil</h3>
        <form action="RegisterServlet" method="post">
            <table class="table">
                <tbody>
                    <tr>
                        <td>
                            <!-- Colonne de gauche -->
                            <div class="mb-3">
                                <label for="pseudo">Pseudo :</label>
                                <input type="text" class="form-control" id="pseudo" name="pseudo">
                            </div>
                            <div class="mb-3">
                                <label for="prenom">Prénom :</label>
                                <input type="text" class="form-control" id="prenom" name="prenom">
                            </div>
                            <div class="mb-3">
                                <label for="telephone">Téléphone :</label>
                                <input type="text" class="form-control" id="telephone" name="telephone">
                            </div>
                            <div class="mb-3">
                                <label for="codePostal">Code Postal :</label>
                                <input type="text" class="form-control" id="codePostal" name="codePostal">
                            </div>
                            <div class="mb-3">
                                <label for="motDePasse">Mot de passe :</label>
                                <input type="password" class="form-control" id="motdepasse" name="motdepasse">
                            </div>
                        </td>
                        <td>
                            <!-- Colonne de droite -->
                            <div class="mb-3">
                                <label for="nom">Nom :</label>
                                <input type="text" class="form-control" id="nom" name="nom">
                            </div>
                            <div class="mb-3">
                                <label for="email">Email :</label>
                                <input type="email" class="form-control" id="email" name="email">
                            </div>
                            <div class="mb-3">
                                <label for="rue">Rue :</label>
                                <input type="text" class="form-control" id="rue" name="rue">
                            </div>
                            <div class="mb-3">
                                <label for="ville">Ville :</label>
                                <input type="text" class="form-control" id="ville" name="ville">
                            </div>
                            <div class="mb-3">
                                <label for="confirmationMotDePasse">Confirmation du mot de passe :</label>
                                <input type="password" class="form-control" id="confirmationMotDePasse" name="confirmationMotDePasse">
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <!-- Boutons en bas de la page -->
                <div class="row">
                    <div class="col-md-6 text-center">
                        <button type="submit" class="btn btn-primary">Créer</button>
                    </div>
                    <div class="col-md-6 text-center">
                        <button type="submit" class="btn btn-primary">Annuler</button>
                    </div>
                </div>
        </form>
        ${message}
    </div>
</body>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchère - Inscription</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
		login:<input type="text" name="pseudo"/>
		nom:<input type="text" name="nom"/>
		prenom:<input type="text" name="prenom"/>
		email:<input type="text" name="email"/>
		téléphone:<input type="text" name="telephone"/>
		rue:<input type="text" name="rue"/>
		code postal:<input type="text" name="codePostal"/>
		ville:<input type="text" name="ville"/>
		mot de passe:<input type="text" name="motdepasse"/>
		<input type="submit" value=">>"/>
	</form>
	${message}
</body>
</html> --%>
</html>