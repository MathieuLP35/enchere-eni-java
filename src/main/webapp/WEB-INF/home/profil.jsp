<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profil</title>
    <!-- Inclure la bibliothèque Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../headerBanner.jsp"/>
    <div class="container mt-4">
        <form>
            <div class="form-group">
                <label for="pseudo">Pseudo :</label>
                <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="${user.pseudo}" readonly>
            </div>
            <div class="form-group">
                <label for="prenom">Prénom :</label>
                <input type="text" class="form-control" id="prenom" name="prenom" placeholder="${user.prenom}" readonly>
            </div>
            <div class="form-group">
                <label for="prenom">Nom :</label>
                <input type="text" class="form-control" id="nom" name="prenom" placeholder="${user.nom}" readonly>
            </div>            
            <div class="form-group">
                <label for="email">Email :</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="${user.email}" readonly>
            </div>
            <div class="form-group">
                <label for="telephone">Téléphone :</label>
                <input type="tel" class="form-control" id="telephone" name="telephone" placeholder="${user.telephone}" readonly>
            </div>
            <div class="form-group">
                <label for="rue">Rue :</label>
                <input type="text" class="form-control" id="rue" name ="rue" placeholder="${user.rue}" readonly>
            </div>
            <div class="form-group">
                <label for="codePostal">Code postal :</label>
                <input type="text" class="form-control" id="codePostal" name="codePostal" placeholder="${user.codePostal}" readonly>
            </div>
            <div class="form-group">
                <label for="ville">Ville :</label>
                <input type="text" class="form-control" id="ville" name="ville" placeholder="${user.ville}" readonly>
            </div>
			<div class="d-flex justify-content-center">
				<a href="${pageContext.request.contextPath}/ModifyProfilServlet" class="btn btn-primary">Modifier</a>
			</div>            
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>


