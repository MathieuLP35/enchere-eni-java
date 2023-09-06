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
<body class="bg-light">
	<jsp:include page="../headerBanner.jsp"/>
    <div class="container text-center mt-5 bg-white rounded p-4 shadow">
        <h3>Inscription</h3>
		<c:if test="${message != null}">
			<div class="alert alert-primary my-2" role="alert">${message}</div>
		</c:if>
		<form action="RegisterServlet" method="post">
            <table class="table">
                <tbody>
                    <tr>
                        <td>
                            <!-- Colonne de gauche -->
                            <div class="mb-3">
                                <label for="pseudo">Pseudo :</label>
                                <input type="text" class="form-control" id="pseudo" name="pseudo" value="${pseudo}">
                            </div>
                            <div class="mb-3">
                                <label for="prenom">Prénom :</label>
                                <input type="text" class="form-control" id="prenom" name="prenom" value="${prenom}">
                            </div>
                            <div class="mb-3">
                                <label for="telephone">Téléphone :</label>
								<input type="tel" class="form-control" id="telephone" name="telephone" value="${telephone}" />
                            </div>
                            <div class="mb-3">
                                <label for="codePostal">Code Postal :</label>
                                <input type="text" class="form-control" id="codePostal" name="codePostal" value="${codePostal}">
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
                                <input type="text" class="form-control" id="nom" name="nom" value="${nom}">
                            </div>
                            <div class="mb-3">
                                <label for="email">Email :</label>
                                <input type="email" class="form-control" id="email" name="email" value="${email}">
                            </div>
                            <div class="mb-3">
                                <label for="rue">Rue :</label>
                                <input type="text" class="form-control" id="rue" name="rue" value="${rue}">
                            </div>
                            <div class="mb-3">
                                <label for="ville">Ville :</label>
                                <input type="text" class="form-control" id="ville" name="ville" value="${ville}">
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
						<a href="${pageContext.request.contextPath}/AccueilServlet" class="btn btn-primary">Annuler</a>
                    </div>
                </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>