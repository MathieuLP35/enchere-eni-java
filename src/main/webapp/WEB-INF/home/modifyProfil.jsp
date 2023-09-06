<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<!-- Définir l'encodage UTF-8 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modifier mon profil</title>
<!-- Ajoutez le lien vers Bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="../../css/styles.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<jsp:include page="../headerBanner.jsp" />
	<div class="container mt-5 bg-white rounded p-4 shadow">
		<h3>Modifier mon profil</h3>
		<c:if test="${message != null || motDePasseErreur != null}">
			<div class="alert alert-primary my-4" role="alert">${message} ${motDePasseErreur}</div>
		</c:if>
		<form action="ModifyProfilServlet" method="post">
			<div class="row">
				<!-- Colonne de gauche -->
				<div class="col-md-6">
					<div class="mb-3">
						<label for="pseudo">Pseudo :</label> <input type="text"
							class="form-control" id="pseudo" name="pseudo"
							value="${user.pseudo}" required>
					</div>
					<div class="mb-3">
						<label for="nom">Nom :</label> <input type="text"
							class="form-control" id="nom" name="nom" value="${user.nom}"
							required>
					</div>
					<div class="mb-3">
						<label for="prenom">Prénom :</label> <input type="text"
							class="form-control" id="prenom" name="prenom"
							value="${user.prenom}" required>
					</div>
					<div class="mb-3">
						<label for="email">Email :</label> <input type="email"
							class="form-control" id="email" name="email"
							value="${user.email}" required>
					</div>
					<div class="mb-3">
						<label for="motDePasse">Mot de passe actuel :</label> <input
							type="password" class="form-control" id="motDePasse"
							name="motDePasse">
					</div>
					<div class="mb-3">
						<label for="nouveauMotDePasse">Nouveau mot de passe :</label> <input
							type="password" class="form-control" id="nouveauMotDePasse"
							name="nouveauMotDePasse">
					</div>
				</div>
				<!-- Colonne de droite -->
				<div class="col-md-6">
					<div class="mb-3">
						<label for="codePostal">Code Postal :</label> <input type="text"
							class="form-control" id="codePostal" name="codePostal"
							value="${user.codePostal}" required>
					</div>
					<div class="mb-3">
						<label for="ville">Ville :</label> <input type="text"
							class="form-control" id="ville" name="ville"
							value="${user.ville}" required>
					</div>
					<div class="mb-3">
						<label for="telephone">Téléphone :</label> <input type="tel"
							class="form-control" id="telephone" name="telephone"
							value="${user.telephone}" required>
					</div>
					<div class="mb-3">
						<label for="rue">Rue :</label> <input type="text"
							class="form-control" id="rue" name="rue" value="${user.rue}"
							required>
					</div>
					<div class="mb-3 mt-3">
						<label for="credit">Crédit :</label> <input type="number"
							class="form-control" id="credit" name="credit" value="${user.credit}"
							required>
					</div>
					<div class="mb-3 mt-3">
						<label for="confirmationMotDePasse">Confirmation :</label> <input
							type="password" class="form-control" id="confirmationMotDePasse"
							name="confirmationMotDePasse">
					</div>
				</div>
			</div>
			<!-- Boutons en bas de la page -->
			<div class="row">
				<div class="col-md-6 text-center">
					<button type="submit" name="BTN_SAVE" class="btn btn-primary">Enregistrer</button>
				</div>
				<div class="col-md-6 text-center">
					<button type="submit" name="BTN_DELETE" class="btn btn-primary">Supprimer</button>
				</div>
			</div>
		</form>
	</div>
</body>


</html>