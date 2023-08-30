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
	<jsp:include page="headerBanner.jsp"/>
    <div class="container mt-4">
        <form>
            <div class="form-group">
                <label for="pseudo">Pseudo :</label>
                <input type="text" class="form-control" id="pseudo" placeholder="Pseudo" readonly>
            </div>
            <div class="form-group">
                <label for="prenom">Prénom :</label>
                <input type="text" class="form-control" id="prenom" readonly>
            </div>
            <div class="form-group">
                <label for="email">Email :</label>
                <input type="email" class="form-control" id="email" placeholder="Email" readonly>
            </div>
            <div class="form-group">
                <label for="telephone">Téléphone :</label>
                <input type="tel" class="form-control" id="telephone" placeholder="Téléphone" readonly>
            </div>
            <div class="form-group">
                <label for="rue">Rue :</label>
                <input type="text" class="form-control" id="rue" placeholder="Rue" readonly>
            </div>
            <div class="form-group">
                <label for="codePostal">Code postal :</label>
                <input type="text" class="form-control" id="codePostal" placeholder="Code postal" readonly>
            </div>
            <div class="form-group">
                <label for="ville">Ville :</label>
                <input type="text" class="form-control" id="ville" placeholder="Ville" readonly>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>


