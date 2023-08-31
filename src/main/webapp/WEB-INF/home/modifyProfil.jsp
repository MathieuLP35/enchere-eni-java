<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8"> <!-- Définir l'encodage UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier mon profil</title>
    <!-- Ajoutez le lien vers Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../headerBanner.jsp"/>
    <div class="container">
        <h3>Modifier mon profil</h3>
 <form action="ModifyProfilServlet" method="post">
    <div class="row">
        <!-- Colonne de gauche -->
        <div class="col-md-6">
            <div class="mb-3">
                <label for="pseudo">Pseudo :</label>
                <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="${user.pseudo}">
            </div>
            <div class="mb-3">
                <label for="nom">Nom :</label>
                <input type="text" class="form-control" id="nom" name="nom" placeholder="${user.nom}">
            </div>
            <div class="mb-3">
                <label for="prenom">Prénom :</label>
                <input type="text" class="form-control" id="prenom" name="prenom" placeholder="${user.prenom}">
            </div>
            <div class="mb-3">
                <label for="email">Email :</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="${user.email}">
            </div>
            <div class="mb-3">
                <label for="motDePasse">Mot de passe actuel :</label>
                <input type="password" class="form-control" id="motdepasse" name="motdepasse">
            </div>            
            <div class="mb-3">
                <label for="nouveauMotDePasse">Nouveau mot de passe :</label>
                <input type="password" class="form-control" id="nouveauMotDePasse" name="nouveauMotDePasse">
            </div>            
        </div>
        <!-- Colonne de droite -->
        <div class="col-md-6">
            <div class="mb-3">
                <label for="codePostal">Code Postal :</label>
                <input type="text" class="form-control" id="codePostal" name="codePostal" placeholder="${user.codePostal}">
            </div>
            <div class="mb-3">
                <label for="ville">Ville :</label>
                <input type="text" class="form-control" id="ville" name="ville" placeholder="${user.ville}">
            </div>
            <div class="mb-3">
                <label for="telephone">Téléphone :</label>
                <input type="text" class="form-control" id="telephone" name="telephone" placeholder="${user.telephone}">
            </div>
            <div class="mb-3">
                <label for="rue">Rue :</label>
                <input type="text" class="form-control" id="rue" name="rue" placeholder="${user.rue}">
            </div>
            <div class="mb-4 offset-mt-3">
            <br/>
            <br/>            
            </div>            
            <div class="mb-3 mt-3">
                <label for="confirmationMotDePasse">Confirmation :</label>
                <input type="password" class="form-control" id="confirmationMotDePasse" name="confirmationMotDePasse">
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

	${message}
    ${motDePasseErreur}
        
    </div>
</body>


</html>